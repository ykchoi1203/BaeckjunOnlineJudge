import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[][] dxdy = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, -1}, {1, 1}, {-1, 1}, {-1, -1}};
        
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            
            if(n == 0 && m == 0) break;
            
            int[][] arr = new int[n][m];
            boolean[][] visited = new boolean[n][m];
            
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }             
            
            
            int cnt = 0;
            
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(arr[i][j] == 1 && !visited[i][j]) {
                        visited[i][j] = true;
                        
                        Queue<int[]> q = new LinkedList<>();
                        
                        q.add(new int[] {i, j});
                        
                        while(!q.isEmpty()) {
                            int[] cur = q.poll();
                            
                            for(int[] d : dxdy) {
                                int x = d[0] + cur[0];
                                int y = d[1] + cur[1];
                                
                                if(x >= 0 && x < n && y >= 0 && y < m && arr[x][y] == 1 && !visited[x][y]) {
                                    visited[x][y] = true;
                                    q.add(new int[] {x, y});
                                }
                            }
                        }
                        
                        cnt++;
                    }
                }
            }
            
            sb.append(cnt).append("\n");
            
        }
        
        System.out.print(sb.toString());
    }
}