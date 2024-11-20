import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[] step = new int[n + 1];
        
        for(int i=1; i<=n; i++) {
            step[i] = sc.nextInt();
        }
        
        int[] dp = new int[n+1];
        
        dp[1] = step[1];
        
        if(n > 1) {
            dp[2] = step[1] + step[2];
        }
        
        for(int i=3; i<=n; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3] + step[i-1]) + step[i];
        }
        
        System.out.println(dp[n]);
        
    }
}