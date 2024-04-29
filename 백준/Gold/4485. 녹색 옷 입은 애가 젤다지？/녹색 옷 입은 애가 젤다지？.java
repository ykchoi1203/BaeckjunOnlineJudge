import java.util.*;
import java.io.*;

class Main {
     static class Cell implements Comparable<Cell> {
        int x, y, cost;

        public Cell(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        public int compareTo(Cell other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    static int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static int dijkstra(int n, int[][] cave) {
        int INF = Integer.MAX_VALUE;
        int[][] distance = new int[n][n];
        for (int[] row : distance) Arrays.fill(row, INF);
        distance[0][0] = cave[0][0]; 

        PriorityQueue<Cell> pq = new PriorityQueue<>();
        pq.offer(new Cell(0, 0, cave[0][0])); 

        while (!pq.isEmpty()) {
            Cell cur = pq.poll();
            if (cur.x == n - 1 && cur.y == n - 1) {
                return cur.cost;
            }

            for (int[] dir : directions) {
                int nx = cur.x + dir[0];
                int ny = cur.y + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    int newCost = cur.cost + cave[nx][ny];
                    if (newCost < distance[nx][ny]) {
                        distance[nx][ny] = newCost;
                        pq.offer(new Cell(nx, ny, newCost));
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pn = 1;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int[][] cave = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] arr = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    cave[i][j] = Integer.parseInt(arr[j]);
                }
            }

            int minLoss = dijkstra(n, cave);
            System.out.println("Problem " + pn + ": " + minLoss);
            pn++;
        }

        br.close();
    }
}