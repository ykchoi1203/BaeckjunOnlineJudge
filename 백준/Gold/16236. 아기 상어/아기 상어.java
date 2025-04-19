import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        size = 2;
        int cnt  = 0;
        int time = 0;

        arr = new int[n][n];
        Queue<int[]> move = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 9) {
                    arr[i][j] = 0;
                    move.add(new int[] {i, j});
                } else if(arr[i][j] != 0){
                    if(!sharkMap.containsKey(arr[i][j])) {
                        sharkMap.put(arr[i][j], new TreeSet<>());
                    }

                    sharkMap.get(arr[i][j]).add(new Fish(i, j));
                }
            }
        }

        while(!move.isEmpty()) {
            int[] cur = move.poll();

            int minMove = Integer.MAX_VALUE;
            int nextX = n;
            int nextY = n;
            Fish eatFish = null;

            for(int i = 1; i < size; i++) {
                if(sharkMap.containsKey(i)) {
                    for (Fish f : sharkMap.get(i)) {
                        int moveLength = countMove(cur[0], cur[1], f.x, f.y);
                        if(moveLength == -1) continue;

                        if (minMove > moveLength) {
                            nextX = f.x;
                            nextY = f.y;
                            minMove = moveLength;
                            eatFish = f;
                        } else if (minMove == moveLength) {
                            if (nextX > f.x) {
                                nextX = f.x;
                                nextY = f.y;
                                eatFish = f;
                            } else if (nextX == f.x && nextY > f.y) {
                                nextY = f.y;
                                eatFish = f;
                            }
                        }
                    }
                }
            }

            if(eatFish != null) {
                move.add(new int[] {nextX, nextY});
                cnt++;
                time += minMove;

                if(cnt == size) {
                    size++;
                    cnt = 0;
                }

                sharkMap.get(arr[nextX][nextY]).remove(eatFish);
            }

        }

        System.out.println(time);

    }

    static int[][] arr;
    static Map<Integer, TreeSet<Fish>> sharkMap = new HashMap<>();

    static class Fish implements Comparable<Fish> {
        int x;
        int y;

        public Fish(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Fish o) {
            return x == o.x ? y - o.y : x - o.x;
        }
    }

    static int[][] dxdy = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int n;
    static int size;

    static int countMove(int curX, int curY, int nextX, int nextY) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {curX, curY, 0});
        boolean[][] visited = new boolean[n][n];

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(nextX == cur[0] && nextY == cur[1]) {
                return cur[2];
            }

            for(int[] d : dxdy) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];

                if(x >= 0 && x < n && y >= 0 && y < n && arr[x][y] <= size && !visited[x][y]) {
                    q.add(new int[] {x, y, cur[2] + 1});
                    visited[x][y] = true;
                }
            }
        }

        return -1;

    }
}
