import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] dp = new long[n + 1];
        Arrays.fill(dp, Long.MAX_VALUE);

        dp[1] = 0;

        ArrayList<int[]> list = new ArrayList<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.add(new int[] {a, b, cost});
        }

        for(int i=1; i<=n; i++) {
            for(int[] edge : list) {
                if(dp[edge[0]] != Long.MAX_VALUE && dp[edge[1]] > dp[edge[0]] + edge[2]) {
                    dp[edge[1]] = dp[edge[0]] + edge[2];
                }
            }
        }

        for(int[] edge : list) {
            if(dp[edge[0]] != Long.MAX_VALUE && dp[edge[1]] > dp[edge[0]] + edge[2]) {
                System.out.println(-1);
                return;
            }
        }

        for(int i=2; i<=n; i++) {
            System.out.println(dp[i] == Long.MAX_VALUE ? -1 : dp[i]);
        }

    }
}
