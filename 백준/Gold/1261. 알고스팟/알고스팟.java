import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n][m];
        int[][] dp = new int[n][m];
        
        for(int i=0; i<n; i++) {
            String s = br.readLine();
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for(int j=0; j<m; j++) {
                arr[i][j] = s.charAt(j) == '1' ? 1 : 0;
            }
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        
        pq.add(new int[] {0, 0, 0});
        dp[0][0] = 0;
        
        int[][] dxdy = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            if(cur[0] == n-1 && cur[1] == m-1) break;
            
            for(int[] d : dxdy) {
                int x = d[0] + cur[0];
                int y = d[1] + cur[1];
                
                if(x >= 0 && x < n && y >= 0 && y < m) {
                    if(arr[x][y] == 0 && dp[x][y] > cur[2]) {
                        dp[x][y] = cur[2];
                        pq.add(new int[] {x, y, cur[2]});
                    } else if(arr[x][y] == 1 && dp[x][y] > cur[2] + 1) {
                        dp[x][y] = cur[2] + 1;
                        pq.add(new int[] {x, y, cur[2] + 1});
                    }
                }
            }
        }
        
        System.out.println(dp[n-1][m-1]);
        
    }
}