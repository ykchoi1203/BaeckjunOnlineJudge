import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] dp = new int[n][3];

        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;

        if(n == 1) {
            System.out.println(3);
            return;
        }

        for(int i = 1; i < n; i++) {
           dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
           dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
           dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
        }

        System.out.println((dp[n - 1][0] + dp[n - 1][1] + dp[n - 1][2]) % 9901);
    }
}
