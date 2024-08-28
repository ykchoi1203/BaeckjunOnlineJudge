import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        
        boolean[][] visited = new boolean[picture.length][picture[0].length];
        int[][] dxdy = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        for(int i=0; i<picture.length; i++) {
            for(int j=0; j<picture[i].length; j++) {
                if(!visited[i][j] && picture[i][j] != 0) {
                    int color = picture[i][j];
                    
                    Queue<int[]> queue = new LinkedList<>();
                    
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
                    answer[0]++;
                    
                    int sum = 1;
                    while(!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        
                        for(int[] d : dxdy) {
                            int x = d[0] + cur[0];
                            int y = d[1] + cur[1];
                            
                            if(x >= 0 && x < picture.length && y >= 0 && y < picture[x].length && !visited[x][y] && picture[x][y] == color) {
                                visited[x][y] = true;
                                queue.add(new int[] {x, y});
                                sum++;
                            }
                        }
                    }
                    
                    answer[1] = Math.max(answer[1], sum);
                }
            }
        }
        
        return answer;
    }
}