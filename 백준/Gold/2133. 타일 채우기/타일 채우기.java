import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long[] dp = new long[31];

        dp[0] = 1;
        dp[2] = 3;

        for(int i=4; i <= 30; i+=2) {
            dp[i] += dp[i-2] * 3;
            for(int j=i-4; j >=2; j-=2) {
                dp[i] += 2 * dp[j];
            }

            dp[i] += 2;
        }

        System.out.println(dp[sc.nextInt()]);

    }
}