import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[2] - a[2]));

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                pq.add(new int[] {i, j, arr[i][j]});
            }
        }

        int[][] dxdy = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int max = 0;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if(dp[cur[0]][cur[1]] == 0) {
                dp[cur[0]][cur[1]] = 1;
            }

            for(int[] d : dxdy) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];

                if(x >= 0 && x < n && y >= 0 && y < n && arr[x][y] > arr[cur[0]][cur[1]]) {
                    dp[cur[0]][cur[1]] = Math.max(dp[cur[0]][cur[1]], dp[x][y] + 1);
                }
            }

            max = Math.max(max, dp[cur[0]][cur[1]]);
        }

        System.out.println(max);
    }
}
