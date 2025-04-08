import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n][n];

        int startX = sc.nextInt();
        int startY = sc.nextInt();
        int endX = sc.nextInt();
        int endY = sc.nextInt();
        int[][] dxdy = new int[][] {{-2, -1}, {-2, 1}, {0, -2}, {0, 2}, {2, -1}, {2, 1}};

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{startX, startY});

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[0] == endX && cur[1] == endY) {
                System.out.println(arr[cur[0]][cur[1]]);
                return;
            }

            for(int[] d : dxdy) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];

                if(x >= 0 && x < n && y >= 0 && y < n && arr[x][y] == 0) {
                    if(startX == x && startY == y) {
                        continue;
                    }
                    arr[x][y] = arr[cur[0]][cur[1]] + 1;
                    q.add(new int[]{x, y});
                }
            }
        }

        System.out.println(-1);
    }

}
