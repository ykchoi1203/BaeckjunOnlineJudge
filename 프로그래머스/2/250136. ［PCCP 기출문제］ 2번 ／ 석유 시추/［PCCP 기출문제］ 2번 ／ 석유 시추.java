import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        
        int[][] arr = new int[land.length][land[0].length];
        int idx = 1;
        int[][] dxdy = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
        
        for(int i=0; i<land[0].length; i++) {
            Set<Integer> set = new HashSet<>();
            int oil = 0;
            for(int j=0; j<land.length; j++) {
                if(land[j][i] == 1 && arr[j][i] == 0) {
                    Queue<int[]> queue = new LinkedList<>();
                    
                    queue.add(new int[] {j, i});
                    arr[j][i] = idx;
                    int sum = 1;
                    
                    while(!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        
                        for(int[] d : dxdy) {
                            int x = d[0] + cur[0];
                            int y = d[1] + cur[1];
                            
                            if(x >= 0 && x < land.length && y >= 0 && y < land[x].length && land[x][y] == 1 && arr[x][y] == 0) {
                                arr[x][y] = idx;
                                queue.add(new int[] {x, y});
                                sum++;
                            }
                        }
                    }
                    list.add(sum);
                    set.add(idx);
                    idx++;
                    oil += sum;
                } else if(land[j][i] == 1 && !set.contains(arr[j][i])) {
                    oil += list.get(arr[j][i]);
                    set.add(arr[j][i]);
                }
            }
            answer = Math.max(oil, answer);
        }
        
        return answer;
    }
}