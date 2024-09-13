import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[][][] rgb = new int[2][][];
        int[] answer = new int[2];
        int[][] dxdy = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        for(int i = 0; i < n; i++) {
            String cur = br.readLine();
            if(i == 0) {
                rgb = new int[2][n][cur.length()];
            }
            
            for(int j=0; j<cur.length(); j++) {
                if(cur.charAt(j) == 'R') {
                    rgb[0][i][j] = 1;
                    rgb[1][i][j] = 1;
                } else if(cur.charAt(j) == 'G') {
                    rgb[0][i][j] = 2;
                    rgb[1][i][j] = 1;
                }
            }
        }
        
        for(int k=0; k<2; k++) {
            boolean[][] visited = new boolean[n][rgb[0][0].length];
            for(int i=0; i<n; i++) {
                for(int j=0; j<visited.length; j++) {
                    if(!visited[i][j]) {
                        answer[k]++;
                        Queue<int[]> queue = new LinkedList<>();
                        
                        queue.add(new int[] {i, j});
                        visited[i][j] = true;
                        
                        while(!queue.isEmpty()) {
                            int[] cur = queue.poll();
                            
                            for(int[] dir : dxdy) {
                                int x = dir[0] + cur[0];
                                int y = dir[1] + cur[1];
                                
                                if(x >= 0 && x < n && y >= 0 && y < visited.length && rgb[k][cur[0]][cur[1]] == rgb[k][x][y] && !visited[x][y]) {
                                    visited[x][y] = true;
                                    queue.add(new int[] {x, y});
                                }
                            }
                        }
                    }
                }
            }
        }
        
        System.out.println(answer[0] + " " + answer[1]);
        
    }
}