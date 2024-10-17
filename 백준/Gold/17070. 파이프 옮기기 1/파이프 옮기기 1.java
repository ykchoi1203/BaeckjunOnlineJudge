import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[n][n];
        int[][][] dp = new int[n][n][3];
        
        for(int i=0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dp[0][1][0] = 1;
        
        for(int i=0; i < n; i++) {
            for(int j=0; j < n; j++) {
                if(i == 0 && j == 0){
                    continue;
                }

                if(arr[i][j] == 1) {
                    continue;
                }

                if(i < n - 1 && arr[i + 1][j] == 0) {
                    dp[i+1][j][1] = dp[i][j][1] + dp[i][j][2];
                }

                if(j < n - 1 && arr[i][j + 1] == 0) {
                    dp[i][j+1][0] = dp[i][j][0] + dp[i][j][2];
                }

                if(i < n - 1 && j < n - 1 && arr[i][j + 1] == 0 && arr[i + 1][j] == 0 && arr[i + 1][j + 1] == 0) {
                    dp[i+1][j+1][2] = dp[i][j][0] + dp[i][j][1] + dp[i][j][2];
                }
            }
        }
        
        System.out.println(dp[n-1][n-1][0] + dp[n-1][n-1][1] + dp[n-1][n-1][2]);
    }
}