import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] rgb = new int[n][3];
        int[][] dp = new int[n+1][3];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int j = 0; j <= 2; j++) {
            Arrays.fill(dp[1], Integer.MAX_VALUE);
            dp[1][j] = rgb[0][j];

            for (int i = 1; i < n; i++) {
                if(dp[i][1] != Integer.MAX_VALUE || dp[i][2] != Integer.MAX_VALUE)
                    dp[i + 1][0] = Math.min(dp[i][1], dp[i][2]) + rgb[i][0];
                else
                    dp[i + 1][0] = Integer.MAX_VALUE;
                if(dp[i][2] != Integer.MAX_VALUE || dp[i][0] != Integer.MAX_VALUE)
                    dp[i + 1][1] = Math.min(dp[i][0], dp[i][2]) + rgb[i][1];
                else
                    dp[i + 1][1] = Integer.MAX_VALUE;
                if(dp[i][1] != Integer.MAX_VALUE || dp[i][0] != Integer.MAX_VALUE)
                    dp[i + 1][2] = Math.min(dp[i][1], dp[i][0]) + rgb[i][2];
                else
                    dp[i + 1][2] = Integer.MAX_VALUE;
            }

            if(j == 0) {
                answer = Math.min(dp[n][1], dp[n][2]);
            } else if(j == 1) {
                answer = Math.min(answer, Math.min(dp[n][0], dp[n][2]));
            } else {
                answer = Math.min(answer, Math.min(dp[n][1], dp[n][0]));
            }
        }

        System.out.println(answer);

    }
}
