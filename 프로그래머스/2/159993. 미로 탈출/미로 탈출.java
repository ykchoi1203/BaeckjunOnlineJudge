import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int[][] count = new int[maps.length][maps[0].length()];
        int[] start = new int[2];
        int[] end = new int[2];
        int[] l = new int[2];
        
        for(int i=0; i<count.length; i++) {
            String[] map = maps[i].split("");
            
            for(int j=0; j<count[i].length; j++) {
                switch(map[j]) {
                    case "S":
                        start[0] = i;
                        start[1] = j;
                        count[i][j] = 1;
                        break;
                    case "E":
                        end[0] = i;
                        end[1] = j;
                        count[i][j] = 2;
                        break;
                    case "L":
                        l[0] = i;
                        l[1] = j;
                        count[i][j] = 3;
                        break;
                    case "O":
                        count[i][j] = 1;
                        break;
                    default:
                        break;
                }
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[] {start[0], start[1], 0});
        boolean[][] visited = new boolean[count.length][count[0].length];
        visited[start[0]][start[1]] = true;
        
        int[][] dxdy = new int[][] { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
        int goL = 0;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(cur[0] == l[0] && cur[1] == l[1]) {
                goL = cur[2];
                break;
            }
            
            for(int[] d : dxdy) {
                int x = d[0] + cur[0];
                int y = d[1] + cur[1];
                
                if(x >= 0 && x < count.length && y >= 0 && y < count[0].length && !visited[x][y] && count[x][y] != 0) {
                    visited[x][y] = true;
                    queue.add(new int[] {x, y, cur[2] + 1});
                }
            }
        }
        
        if(goL == 0) return -1;
        
        queue = new LinkedList<>();
        queue.add(new int[] {l[0], l[1], goL});
        visited = new boolean[count.length][count[0].length];
        visited[l[0]][l[1]] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(cur[0] == end[0] && end[1] == cur[1]) {
                return cur[2];
            }
            
            for(int[] d : dxdy) {
                int x = d[0] + cur[0];
                int y = d[1] + cur[1];
                
                if(x >= 0 && x < count.length && y >= 0 && y < count[0].length && !visited[x][y] && count[x][y] != 0) {
                    visited[x][y] = true;
                    queue.add(new int[] {x, y, cur[2] + 1});
                }
            }
        }
        
        return -1;
    }
}