import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        int answer = Integer.MAX_VALUE;
        int x;
        int y;

        Queue<int[]> queue = new LinkedList<>();
        Set<Fire> fires = new HashSet<>();

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            for(int j=0; j<m; j++) {
                if(s.charAt(j) == 'J') {
                    x = i;
                    y = j;
                    visited[x][y] = true;
                    queue.add(new int[] {x, y, 0});
                } else if(s.charAt(j) == 'F') {
                    arr[i][j] = 1;
                    fires.add(new Fire(i, j));
                } else if(s.charAt(j) == '#') {
                    arr[i][j] = 2;
                }
            }
        }

        int fire = 0;
        int[][] dxdy = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            if(fire < cur[2]) {
               Set<Fire> newFire = new HashSet<>();

               for(Fire f : fires) {
                   for(int[] d : dxdy) {
                       int nextX = f.x + d[0];
                       int nextY = f.y + d[1];

                       if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m
                       && arr[nextX][nextY] == 0) {
                           newFire.add(new Fire(nextX, nextY));
                           arr[nextX][nextY] = 1;
                       }
                   }
               }
               fires = newFire;
               fire++;
            }

            if(arr[cur[0]][cur[1]] != 0) continue;

            if(cur[0] == 0 || cur[0] == n-1 || cur[1] == 0 || cur[1] == m-1) {
                answer = cur[2] + 1;
                break;
            }

            for(int[] d : dxdy) {
                int nextX = d[0] + cur[0];
                int nextY = d[1] + cur[1];

                if(nextX >= 0 && nextY >= 0 && nextX < n && nextY < m
                        && arr[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                    queue.add(new int[] {nextX, nextY, cur[2] + 1});
                    visited[nextX][nextY] = true;
                }
            }

        }

        System.out.println(answer == Integer.MAX_VALUE ? "IMPOSSIBLE" : answer);

    }

    public static class Fire {
        int x;
        int y;

        public Fire(int x, int y) {
            this.x = x;
            this.y = y;
        }


        @Override
        public int hashCode() {
            return 1000 * x + y;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Fire) {
                Fire other = (Fire)obj;
                return x == other.x && y == other.y;
            }
            return false;
        }
    }
}
