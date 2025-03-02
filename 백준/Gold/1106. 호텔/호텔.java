import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int c = sc.nextInt();
        int n = sc.nextInt();
        
        int[][] arr = new int[n][2];
        
        int[] dp = new int[c + 1];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0] = 0;
        
        for(int i=0; i<n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            arr[i][0] = a;
            arr[i][1] = b;
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<=c; j++) {
                if(dp[j] != Integer.MAX_VALUE) {
                    if(j + arr[i][1] <= c) {
                        dp[j + arr[i][1]] = Math.min(dp[j + arr[i][1]], dp[j] + arr[i][0]);
                    } else {
                        dp[c] = Math.min(dp[c], dp[j] + arr[i][0]);
                    }
                }
            }
        }
        
        System.out.println(dp[c]);
        
    }
}