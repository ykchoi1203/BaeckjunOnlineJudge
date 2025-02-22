import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            for(int j=0; j<m; j++) {
                if(s.charAt(j) == 'T') {
                    arr[i][j] = 1;
                }
            }
        }

        visited = new boolean[n][m];
        visited[n-1][0] = true;
        dfs(1, n-1, 0);

        System.out.println(answer);

    }

    static int[][] arr;
    static boolean[][] visited;
    static int k;
    static int n;
    static int m;
    static int answer = 0;
    static int[][] dxdy = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static void dfs(int cnt, int x, int y) {
        if(cnt > k) return;

        if(x == 0 && y == m-1) {
            if(cnt == k) answer++;
            return;
        }

        for(int[] d : dxdy) {
            int nextX = x + d[0];
            int nextY = y + d[1];

            if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m
            && !visited[nextX][nextY] && arr[nextX][nextY] == 0) {
                visited[nextX][nextY] = true;
                dfs(cnt+1, nextX, nextY);
                visited[nextX][nextY] = false;
            }
        }
    }
}
