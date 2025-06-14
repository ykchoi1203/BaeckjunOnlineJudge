import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][][] arr = new int[n + 1][m + 1][2];
        long[][] dp = new long[n + 1][m + 1];
        dp[0][0] = 1;

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            if(x1 == x2) {
                arr[x1][Math.max(y1, y2)][1] = 1;
            } else {
                arr[Math.max(x1, x2)][y1][0] = 1;
            }
        }

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if(i == 0 && j == 0) continue;
                if(arr[i][j][0] == 0 && i != 0) {
                    dp[i][j] += dp[i - 1][j];
                }

                if(arr[i][j][1] == 0 && j != 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }

        System.out.println(dp[n][m]);

    }
}
