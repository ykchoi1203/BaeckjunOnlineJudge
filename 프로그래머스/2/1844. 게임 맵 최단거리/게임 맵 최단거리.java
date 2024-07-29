import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        int[][] dxdy = new int[][] {{1,0}, {0,1}, {-1,0}, {0,-1}};
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for(int[] d : dxdy) {
                int x = d[0] + cur[0];
                int y = d[1] + cur[1];
                
                if(x >= 0 && x < maps.length && y >= 0 && y < maps[0].length
                  && maps[x][y] == 1 && !visited[x][y]) {
                    if(x == maps.length -1 && y == maps[0].length -1) {
                        return cur[2] + 1;
                    }
                    queue.add(new int[] {x, y, cur[2] + 1});
                    visited[x][y] = true;
                }
                
            }
        }
        
        return answer;
    }
}