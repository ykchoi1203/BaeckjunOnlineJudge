import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        boolean hasIce = false;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] != 0) hasIce = true;
            }
        }

        if(!hasIce) {
            System.out.println(0);
            return;
        }

        int[][] dxdy = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int time = 1;
        while(true) {
            boolean[][] visited = new boolean[n][m];
            int[][] newArr = new int[n][m];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(arr[i][j] != 0) {
                        newArr[i][j] = arr[i][j];
                        for(int[] d : dxdy) {
                            int x = i + d[0];
                            int y = j + d[1];

                            if(x >= 0 && x < n && y >= 0 && y < m && arr[x][y] == 0) {
                                newArr[i][j]--;
                                if(newArr[i][j] == 0) break;
                            }
                        }
                    }
                }
            }

            arr = newArr;
            int cnt = 0;
            loop:
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(arr[i][j] != 0 && !visited[i][j]) {
                        visited[i][j] = true;
                        Queue<int[]> q = new LinkedList<>();
                        q.add(new int[] {i, j});
                        cnt++;

                        if(cnt > 1) break loop;

                        while(!q.isEmpty()) {
                            int[] cur = q.poll();

                            for(int[] d : dxdy) {
                                int x = cur[0] + d[0];
                                int y = cur[1] + d[1];

                                if(x >= 0 && x < n && y >= 0 && y < m && arr[x][y] != 0 && !visited[x][y]) {
                                    visited[x][y] = true;
                                    q.add(new int[] {x, y});
                                }
                            }
                        }
                    }
                }
            }

            if(cnt > 1) {
                System.out.println(time);
                return;
            }
            else if(cnt == 0) {
                System.out.println(0);
                return;
            }

            time++;
        }
    }
}
