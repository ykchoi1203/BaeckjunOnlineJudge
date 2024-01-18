import java.util.Arrays;
class Solution {
    public long solution(int n) {
        long answer = 0;
        long[] dp = new long[n];
        if(n == 1) return 1;
        dp[0] = 1;
        dp[1] = 2;
        
        for(int i=2; i<n; i++) {
            dp[i] = (dp[i] + dp[i-2] + dp[i-1]) % 1234567;
        }
        
        answer = (int)(dp[n-1]);
        
        
        return answer;
    }
}