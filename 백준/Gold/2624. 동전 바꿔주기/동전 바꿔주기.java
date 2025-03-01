import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int k = sc.nextInt();
        int[][] arr = new int[k][2];

        for(int i = 0; i < k; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        int[][] dp = new int[k + 1][n + 1];

        for(int i = 0; i < k; i++) {
            for(int l=1; l <= arr[i][1]; l++) {
                int coin = arr[i][0] * l;
                for (int j = 0; j + coin <= n; j++) {
                    dp[i + 1][j + coin] += dp[i][j];
                }
                if(coin <= n)
                    dp[i + 1][coin]++;
            }

            for(int j = 1; j <= n; j++) {
                dp[i + 1][j] += dp[i][j];
            }
        }

        System.out.println(dp[k][n]);
    }
}
