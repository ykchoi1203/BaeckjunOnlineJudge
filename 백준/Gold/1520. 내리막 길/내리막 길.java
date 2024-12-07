import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int[][] dp = new int[n][m];

        dp[0][0] = 1;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        boolean[][] visited = new boolean[n][m];
        pq.add(new int[] {0, 0, arr[0][0]});
        visited[0][0] = true;

        int[][] dxdy = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();

            for(int[] d : dxdy) {
                int x = d[0] + cur[0];
                int y = d[1] + cur[1];

                if(x >= 0 && x < n && y >= 0 && y < m && arr[x][y] < cur[2]) {
                    if(!visited[x][y]) {
                        pq.add(new int[]{x, y, arr[x][y]});
                        visited[x][y] = true;
                    }
                    dp[x][y] += dp[cur[0]][cur[1]];
                }
            }
        }

        System.out.println(dp[n-1][m-1]);

    }
}
