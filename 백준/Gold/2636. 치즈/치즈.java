import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
        n = arr.length;
        m = arr[0].length;
        air = new boolean[n][m];

        int cheese = 0;
        int answer = 0;

        for(int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) cheese++;
            }
        }

        int time = 0;

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0});
        air[0][0] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int[] d : dxdy) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];

                if(x >= 0 && x < n && y >= 0 && y < m && arr[x][y] == 0 && !air[x][y]) {
                    air[x][y] = true;
                    q.add(new int[]{x, y});
                }
            }
        }

        while(cheese > 0) {
            answer = cheese;
            Set<int[]> remove = new HashSet<>();
            for(int i = 0; i < arr.length; i++) {
                for(int j = 0; j < arr[i].length; j++) {
                    if(arr[i][j] == 1) {
                        for(int[] d : dxdy) {
                            int x = i + d[0];
                            int y = j + d[1];

                            if(x >= 0 && x < n && y >= 0 && y < m && air[x][y]) {
                                arr[i][j] = 0;
                                cheese--;
                                remove.add(new int[]{i, j});
                                break;
                            }
                        }
                    }
                }
            }

            for(int[] cur : remove) {
                air[cur[0]][cur[1]] = true;

                Queue<int[]> newAir = new LinkedList<>();
                newAir.add(new int[]{cur[0], cur[1]});

                while(!newAir.isEmpty()) {
                    int[] next = newAir.poll();

                    for(int[] d : dxdy) {
                        int x = next[0] + d[0];
                        int y = next[1] + d[1];

                        if(x >= 0 && x < n && y >= 0 && y < m && arr[x][y] == 0 && !air[x][y]) {
                            air[x][y] = true;
                            newAir.add(new int[]{x, y});
                        }
                    }
                }
            }

            time++;
        }

        System.out.println(time);
        System.out.println(answer);

    }

    static int[][] arr;
    static boolean[][] air;

    static int[][] dxdy = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int n, m;
}
