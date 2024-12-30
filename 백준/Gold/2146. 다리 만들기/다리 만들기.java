import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        int[][] map = new int[n][n];
        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) dp[i][j] = 0;
            }
        }

        int num = 1;
        boolean[][] visited = new boolean[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && arr[i][j] == 1) {
                    map[i][j] = num;
                    visited[i][j] = true;

                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[] {i, j});

                    while(!q.isEmpty()) {
                        int[] cur = q.poll();

                        for(int[] d : dxdy) {
                            int x = d[0] + cur[0];
                            int y = d[1] + cur[1];

                            if(x >= 0 && x < n && y >= 0 && y < n
                                    && arr[x][y] == 1 && !visited[x][y]) {
                                visited[x][y] = true;
                                map[x][y] = num;
                                q.add(new int[] {x, y});
                            }
                        }
                    }
                    num++;
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(arr[i][j] == 1 && checkSea(arr, i, j)) {
                    Queue<int[]> q = new LinkedList<>();
                    int number = map[i][j];
                    for(int[] d : dxdy) {
                        int x = d[0] + i;
                        int y = d[1] + j;

                        if(x >= 0 && x < n && y >= 0 && y < n
                                && arr[x][y] == 0 && dp[x][y] > 1) {
                            q.add(new int[] {x, y, 1});
                            dp[x][y] = 1;
                        }
                    }

                    loop:
                    while(!q.isEmpty()) {
                        int[] cur = q.poll();

                        for(int[] d : dxdy) {
                            int x = d[0] + cur[0];
                            int y = d[1] + cur[1];

                            if(x >= 0 && x < n && y >= 0 && y < n) {
                                if(dp[x][y] == 0 && map[x][y] != number) {
                                    answer = Math.min(answer, cur[2]);
                                    break loop;
                                }

                                if(arr[x][y] == 0 && dp[x][y] > cur[2] + 1) {
                                    dp[x][y] = cur[2] + 1;
                                    q.add(new int[] {x, y, dp[x][y]});
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }

    static int[][] dxdy = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int n;

    public static boolean checkSea(int[][] arr, int i, int j) {
        for(int[] d : dxdy) {
            int x = d[0] + i;
            int y = d[1] + j;

            if(x >= 0 && x < n && y >= 0 && y < n
                    && arr[x][y] == 0) {
                return true;
            }
        }

        return false;
    }
}
