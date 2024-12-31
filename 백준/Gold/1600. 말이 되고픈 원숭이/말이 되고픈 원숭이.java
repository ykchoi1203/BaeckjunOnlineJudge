import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int[][] dp = new int[n][m];
        boolean[][][] visited = new boolean[k+1][n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[3] - b[3]);
        int[][] horse = new int[][] {{-2, -1}, {-1, -2}, {1, -2}, {2, -1},
                {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};
        int[][] dxdy = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        dp[0][0] = 0;
        visited[k][0][0] = true;
        pq.add(new int[] {0, 0, k, 0});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if(cur[0] == n-1 && cur[1] == m-1) {
                continue;
            }

            if(cur[2] > 0) {
                for(int[] next : horse) {
                    int x = cur[0] + next[0];
                    int y = cur[1] + next[1];

                    if(x >= 0 && x < n && y >= 0 && y < m && arr[x][y] == 0
                            && !visited[cur[2] - 1][x][y]) {
                        pq.add(new int[] {x, y, cur[2]-1, cur[3] + 1});
                        dp[x][y] = Math.min(dp[x][y], cur[3] + 1);
                        visited[cur[2] - 1][x][y] = true;
                        visited[cur[2] - 1][cur[0]][cur[1]] = true;
                    }
                }
            }

            for(int[] next : dxdy) {
                int x = next[0] + cur[0];
                int y = next[1] + cur[1];

                if(x >= 0 && x < n && y >= 0 && y < m && arr[x][y] == 0
                        && !visited[cur[2]][x][y]) {
                    pq.add(new int[] {x, y, cur[2], cur[3] + 1});
                    dp[x][y] = Math.min(cur[3] + 1, dp[x][y]);
                    visited[cur[2]][x][y] = true;
                    visited[cur[2]][cur[0]][cur[1]] = true;
                }
            }
        }

        System.out.println(dp[n-1][m-1] == Integer.MAX_VALUE ? -1 : dp[n-1][m-1]);

    }
}


