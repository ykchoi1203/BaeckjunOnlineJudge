import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][101];
        int[][] arr = new int[n][2];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= 100; j++) {
                if(j <= arr[i][0]) {
                    dp[i + 1][j] = dp[i][j];
                    continue;
                }

                dp[i + 1][j] = Math.max(dp[i][j], Math.max(dp[i + 1][j], dp[i][j - arr[i][0]] + arr[i][1]));
            }
        }

        System.out.println(Arrays.stream(dp[n]).max().getAsInt());


    }
}
