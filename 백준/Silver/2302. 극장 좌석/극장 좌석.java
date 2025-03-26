import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[41];

        dp[0] = 1; dp[1] = 1;
        for(int i=2; i < 41; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        int k = sc.nextInt();
        int end = 1;
        long cnt = 1;

        for(int i=0; i<k; i++) {
            int m = sc.nextInt();
            if(end == m) {
                end++;
            } else {
                cnt *= dp[m - end];
                end = m + 1;
            }
        }

        if(end < n) {
            cnt *= dp[n + 1 - end];
        }

        System.out.println(cnt);

    }
}
