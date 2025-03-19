import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        int startX = 0, startY = 0;

        for(int i=0;i<n;i++) {
            String s = br.readLine();
            for(int j=0;j<m;j++) {
                switch (s.charAt(j)) {
                    case 'D':
                        arr[i][j] = 2;
                        break;
                    case 'S':
                        startX = i;
                        startY = j;
                        visited[i][j] = true;
                        break;
                    case 'X':
                        arr[i][j] = 3;
                        break;
                    case '*':
                        arr[i][j] = 4;
                        break;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {startX, startY, 0});

        int time = -1;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(time != cur[2]) {
                arr = water(arr);
                time++;
            }

            for(int[] d : dxdy) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];

                if(x >= 0 && x < n && y >= 0 && y < m && !visited[x][y]
                && arr[x][y] != 4 && arr[x][y] != 3) {
                    visited[x][y] = true;
                    q.add(new int[] {x, y, cur[2] + 1});

                    if(arr[x][y] == 2) {
                        System.out.println(cur[2] + 1);
                        return;
                    }

                }
            }

        }

        System.out.println("KAKTUS");

    }

    static int[][] dxdy = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static int[][] water(int[][] arr) {
        int[][] newArr = new int[arr.length][arr[0].length];

        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[0].length;j++) {
                if(newArr[i][j] == 0) {
                    newArr[i][j] = arr[i][j];
                }

                if(arr[i][j] == 4) {
                    for(int[] d : dxdy) {
                        int x = d[0] + i;
                        int y = d[1] + j;

                        if(x >= 0 && x < newArr.length && y >= 0 && y < newArr[0].length
                        && arr[x][y] == 0) {
                            newArr[x][y] = 4;
                        }
                    }
                }
            }
        }

        return newArr;
    }
}
