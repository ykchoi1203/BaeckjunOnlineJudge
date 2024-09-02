import java.util.*;
class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        
        long[] dp = new long[n + 1];
        dp[0] = 1;
        
        for(int coin : money) {
            for(int i = coin; i < n + 1; i++) {
                dp[i] += dp[i - coin];
            }
        }
        
        return (int)(dp[n] % 1000000007);
    }
}