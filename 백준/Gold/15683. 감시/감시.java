import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = n * m;

        arr = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] != 0) {
                    answer--;
                    if(arr[i][j] != 6) {
                        list.add(new int[] {i, j});
                    }
                }

            }
        }

        backtrack(0, answer);

        System.out.println(answer);

    }

    static void backtrack(int idx, int count) {
        if(idx == list.size()) {
            answer = Math.min(answer, count);
            return;
        }

        int[] cctvIdx = list.get(idx);
        int k = arr[cctvIdx[0]][cctvIdx[1]] - 1;

        for(int i=0; i<cctv[k].length; i++) {
            List<int[]> areas = new ArrayList<>();

            for(int j=0; j<cctv[k][i].length; j++) {
                int x = cctvIdx[0] + dxdy[cctv[k][i][j]][0];
                int y = cctvIdx[1] + dxdy[cctv[k][i][j]][1];

                while(x >=0 && x < n && y >= 0 && y < m &&
                        arr[x][y] != 6) {
                    if(arr[x][y] == 0) {
                        areas.add(new int[] {x, y});
                        arr[x][y] = 7;
                    }

                    x += dxdy[cctv[k][i][j]][0];
                    y += dxdy[cctv[k][i][j]][1];
                }
            }

            backtrack(idx + 1, count - areas.size());

            for(int[] area : areas) {
                arr[area[0]][area[1]] = 0;
            }

        }

    }

    static int[][] arr;
    static int answer;
    static int n, m;
    static int[][] dxdy = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int[][][] cctv = new int[][][] {{{0}, {1}, {2}, {3}},
            {{0, 2}, {1, 3}},
            {{0, 1}, {0, 3}, {1, 2}, {2, 3}},
            {{0, 1, 2}, {0, 1, 3}, {0, 2, 3}, {1, 2, 3}},
            {{0, 1, 2, 3}}};

    static ArrayList<int[]> list = new ArrayList<>();

}
