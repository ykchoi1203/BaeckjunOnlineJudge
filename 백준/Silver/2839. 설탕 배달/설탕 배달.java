import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        if(n < 5) {
            if(n == 3) {
                System.out.println(1);
            } else {
                System.out.println(-1);
            }
            return;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[3] = 1;
        dp[5] = 1;
        int[] bag = new int[] {3, 5};
        for(int weight : bag) {
            for(int i = weight + 1; i < dp.length; i++) {
                if(dp[i-weight] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i-weight] + 1, dp[i]);
            }
        }
        
        System.out.println(dp[n] == Integer.MAX_VALUE ? -1 : dp[n]);
        
    }
}