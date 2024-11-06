import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        isOutSide = new boolean[n][m];

        int cntCheese = 0;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(i == 0 || i == n-1 || j == 0 || j == m-1) {
                    isOutSide[i][j] = true;
                }

                if(arr[i][j] == 1) {
                    cntCheese++;
                }
            }
        }

        int time = 0;

        while(true) {
            time++;

            changeAir();

            List<int[]> melted = new ArrayList<>();

            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(arr[i][j] == 1) {
                        int cnt = 0;

                        for(int[] d : dxdy) {
                            int nextX = d[0] + i;
                            int nextY = d[1] + j;

                            if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && isOutSide[nextX][nextY]) {
                                cnt++;
                            }

                            if(cnt >= 2) break;
                        }

                        if(cnt == 2) {
                            melted.add(new int[]{i, j});
                        }
                    }
                }
            }

            cntCheese -= melted.size();

            if(cntCheese == 0) {
                break;
            }

            for(int[] cheese : melted) {
                arr[cheese[0]][cheese[1]] = 0;
                isOutSide[cheese[0]][cheese[1]] = true;
            }
        }

        System.out.println(time);


    }

    static boolean[][] isOutSide;
    static int[][] arr;
    static int n;
    static int m;

    static int[][] dxdy = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void changeAir() {
        List<int[]> addAir = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int[] d : dxdy) {
                int nextX = d[0] + cur[0];
                int nextY = d[1] + cur[1];

                if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && arr[nextX][nextY] == 0
                        && !visited[nextX][nextY]) {

                    if(!isOutSide[nextX][nextY]) {
                        addAir.add(new int[] {nextX, nextY});
                    }
                    queue.add(new int[] {nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }


        for(int[] cur : addAir) {
            isOutSide[cur[0]][cur[1]] = true;
        }
    }
}
