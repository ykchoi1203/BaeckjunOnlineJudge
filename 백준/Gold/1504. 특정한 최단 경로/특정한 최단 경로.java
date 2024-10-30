import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] dp = new int[n][n];
        
        for(int i=0; i<n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i] = 0;
        }
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            
            dp[start][end] = Math.min(dp[start][end], cost);
            dp[end][start] = Math.min(dp[end][start], cost);
        }
        
        st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken()) - 1;
        int b = Integer.parseInt(st.nextToken()) - 1;
        
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(i == j) continue;
                    if(dp[i][k] != Integer.MAX_VALUE && dp[k][j] != Integer.MAX_VALUE 
                       && dp[i][j] > dp[i][k] + dp[k][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                    }
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        
        if(dp[0][a] != Integer.MAX_VALUE && dp[a][b] != Integer.MAX_VALUE && dp[b][n-1] != Integer.MAX_VALUE) {
            answer = dp[0][a] + dp[a][b] + dp[b][n-1];
        }
        
        if(dp[0][b] != Integer.MAX_VALUE && dp[b][a] != Integer.MAX_VALUE && dp[a][n-1] != Integer.MAX_VALUE) {
            answer = Math.min(answer, dp[0][b] + dp[b][a] + dp[a][n-1]);
        }
        
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
        
    }
}