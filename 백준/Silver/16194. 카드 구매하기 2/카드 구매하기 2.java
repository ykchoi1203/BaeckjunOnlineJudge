import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, 10000000);

        dp[0] = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j + i + 1 <= n; j++) {
                dp[j + i + 1] = Math.min(arr[i] + dp[j], dp[j + i + 1]);
            }
        }

        System.out.println(dp[n]);
    }
}
