import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][][] dp = new int[k+1][n][m];
        int[][] arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            String nums = br.readLine();
            for(int j = 0; j < m; j++) {
                arr[i][j] = nums.charAt(j) - '0';

            }
        }

        for(int i=0; i<=k; i++) {
            for(int j=0; j<n; j++) {
                Arrays.fill(dp[i][j], n * m + 1);
            }
            dp[i][0][0] = 1;
        }

        int[][] dxdy = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {0, 0, 1, 0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[3] > k) continue;

            for(int[] d : dxdy) {
                int x = d[0] + cur[0];
                int y = d[1] + cur[1];

                if(x >= 0 && x < n && y >= 0 && y < m) {
                    if(arr[x][y] == 1 && cur[3] + 1 <= k && dp[cur[3] + 1][x][y] > cur[2] + 1) {
                        dp[cur[3] + 1][x][y] = cur[2] + 1;
                        q.add(new int[] {x, y, cur[2] + 1, cur[3] + 1});
                    } else if(arr[x][y] == 0 && dp[cur[3]][x][y] > cur[2] + 1) {
                        dp[cur[3]][x][y] = cur[2] + 1;
                        q.add(new int[] {x, y, cur[2] + 1, cur[3]});
                    }
                }
            }
        }

        int answer = n * m + 1;

        for(int i=0; i<=k; i++) {
            answer = Math.min(answer, dp[i][n-1][m-1]);
        }

        System.out.println(answer == n * m + 1 ? -1 : answer);

    }
}
