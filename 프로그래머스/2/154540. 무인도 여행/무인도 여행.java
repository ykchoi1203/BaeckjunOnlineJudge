import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        int[] answer = {};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[][] dxdy = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        int[][] intMap = new int[maps.length][maps[0].length()];
        boolean[][] visited = new boolean[intMap.length][intMap[0].length];
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<intMap.length; i++) {
            String[] map = maps[i].split("");
            
            for(int j=0; j<map.length; j++) {
                if(!map[j].equals("X")) {
                    intMap[i][j] = Integer.parseInt(map[j]);
                }
            }
        }
        
        for(int i=0; i<intMap.length; i++) {
            for(int j=0; j<intMap[i].length; j++) {
                if(!visited[i][j] && intMap[i][j] != 0)  {
                    int sum = 0;
                    
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[] {i, j});
                    
                    while(!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        
                        if(!visited[cur[0]][cur[1]]) {
                            visited[cur[0]][cur[1]] = true;
                            sum += intMap[cur[0]][cur[1]];
                            for(int[] d : dxdy) {
                                int x = cur[0] + d[0];
                                int y = cur[1] + d[1];
                                
                                if(x >= 0 && x < intMap.length && y >= 0 && y < intMap[0].length && !visited[x][y] && intMap[x][y] != 0) {
                                    queue.add(new int[] {x, y});
                                }
                            }
                        }
                    }
                    
                    list.add(sum);
                }
            }
        }
        
        if(list.isEmpty()) return new int[] {-1};
        
        answer = new int[list.size()];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}