import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[] dp = new int[k + 1];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        int[] coins = new int[n];
        
        for(int i=0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        
        for(int coin : coins) {
            for(int i=coin; i <= k; i++) {
                if(dp[i - coin] == Integer.MAX_VALUE) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        
        System.out.println(dp[k] == Integer.MAX_VALUE ? -1 : dp[k]);
    }
}