import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[k+1];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int coin : arr) {
            if(coin <= k)
                dp[coin]++;

            for(int i=1; i + coin <=k; i++) {
                dp[i + coin] += dp[i];
            }

        }

        System.out.println(dp[k]);

    }
}
