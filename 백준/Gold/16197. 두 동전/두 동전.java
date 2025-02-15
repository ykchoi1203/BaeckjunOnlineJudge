import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        int[] a = new int[2];
        int[] b = new int[2];

        a[0] = -1;

        for(int i=0; i<n; i++) {
            String s = br.readLine();

            for(int j=0; j<m; j++) {
                switch(s.charAt(j)) {
                    case 'o':
                        arr[i][j] = 2;
                        if(a[0] == -1) {
                            a[0] = i;
                            a[1] = j;
                        } else {
                            b[0] = i;
                            b[1] = j;
                        }
                        break;
                    case '#':
                        arr[i][j] = 1;
                        break;
                }
            }
        }

        Set<Visited> visited = new HashSet<>();
        visited.add(new Visited(a[0], a[1], b[0], b[1]));

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {a[0], a[1], b[0], b[1], 0});

        while(!q.isEmpty()) {
            int[] vis = q.poll();

            if(((vis[0] < 0 || vis[0] >= n || vis[1] < 0 || vis[1] >= m) && (vis[2] >= 0 && vis[2] < n && vis[3] >= 0 && vis[3] < m))
                    || ((vis[2] < 0 || vis[2] >= n || vis[3] < 0 || vis[3] >= m) && (vis[0] >= 0 && vis[0] < n && vis[1] >= 0 && vis[1] < m))
            ) {
                System.out.println(vis[4]);
                return;
            } else if(vis[4] >= 10) continue;

            for(int[] d : dxdy) {
                int nextX1 = d[0] + vis[0];
                int nextY1 = d[1] + vis[1];
                int nextX2 = d[0] + vis[2];
                int nextY2 = d[1] + vis[3];

                if(nextX1 >= 0 && nextX1 < n && nextY1 >= 0 && nextY1 < m && arr[nextX1][nextY1] == 1) {
                    nextX1 -= d[0];
                    nextY1 -= d[1];
                }

                if(nextX2 >= 0 && nextX2 < n && nextY2 >= 0 && nextY2 < m && arr[nextX2][nextY2] == 1) {
                    nextX2 -= d[0];
                    nextY2 -= d[1];
                }

                if(((nextX1 < 0 || nextX1 >= n) && (nextX2 < 0 || nextX2 >= n))
                        || ((nextY1 < 0 || nextY1 >= m) && (nextY2 < 0 || nextY2 >= m))
                    || ((nextX1 < 0 || nextX1 >= n) && (nextY2 < 0 || nextY2 >= m))
                    || ((nextY1 < 0 || nextY1 >= m) && (nextX2 < 0 || nextX2 >= n))) {
                    continue;
                }

                if(nextX1 == nextX2 && nextY1 == nextY2) {
                    continue;
                }

                if(!visited.contains(new Visited(nextX1, nextY1, nextX2, nextY2))) {
                    q.add(new int[] {nextX1, nextY1, nextX2, nextY2, vis[4] + 1});
                    visited.add(new Visited(nextX1, nextY1, nextX2, nextY2));
                }
            }
        }

        System.out.println(-1);

    }

    static int[][] dxdy = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int[][] arr;
    static int n;
    static int m;
    static int answer = 11;

    public static class Visited implements Comparable<Visited> {
        int x1, y1, x2, y2;

        public Visited(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }


        @Override
        public int compareTo(Visited o) {
            return x1 == o.x1 && y1 == o.y1 && x2 == o.x2 && y2 == o.y2 ? 0 : 1;
        }

        @Override
        public boolean equals(Object obj) {
            Visited v = (Visited) obj;
            return x1 == v.x1 && y1 == v.y1 && x2 == v.x2 && y2 == v.y2;
        }

        @Override
        public int hashCode() {
            return 8000 * x1 + 400 * y1 + 20 * x2 +  y2;
        }

    }
}
