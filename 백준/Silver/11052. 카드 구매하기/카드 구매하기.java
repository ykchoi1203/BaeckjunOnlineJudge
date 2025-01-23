import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n + 1];

        for(int i=1; i<=n; i++)
            arr[i] = sc.nextInt();

        int[] dp = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j + i <= n; j++) {
                dp[j + i] = Math.max(dp[j + i], dp[j] + arr[i]);
            }
        }

        System.out.println(dp[n]);
        
    }
}