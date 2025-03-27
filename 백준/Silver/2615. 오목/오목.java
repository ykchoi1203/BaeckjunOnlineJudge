import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<19; i++) {
            for(int j=0; j<19; j++) {
                if(arr[i][j] != 0) {
                    Queue<int[]> q = new LinkedList<>();

                    for(int k=0; k<4; k++) {
                        if(!visited[k][i][j]) {
                            q.add(new int[] {i, j, k, 1});
                            visited[k][i][j] = true;
                        }
                    }

                    while(!q.isEmpty()) {
                        int[] cur = q.poll();

                        int x = cur[0] + dxdy[cur[2]][0];
                        int y = cur[1] + dxdy[cur[2]][1];

                        if(x >= 0 && x < 19 && y >= 0 && y < 19 && !visited[cur[2]][x][y] && arr[x][y] == arr[i][j]) {
                            q.add(new int[] {x, y, cur[2], cur[3] + 1});
                            visited[cur[2]][x][y] = true;
                        } else if(cur[3] == 5) {
                            System.out.println(arr[i][j]);
                            if(cur[2] == 3) {
                                System.out.println((cur[0] + 1) + " " + (cur[1] + 1));
                            } else {
                                System.out.println((i + 1) + " " + (j + 1));
                            }
                            return;
                        }
                    }
                }
            }
        }

        System.out.println(0);

    }

    static int[][] dxdy = new int[][] {{1, 0}, {0, 1}, {1, 1}, {1, -1}};
    static int[][] arr = new int[19][19];
    static boolean[][][] visited = new boolean[4][19][19];
}
