import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());

        int apple = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        for(int i = 0; i < apple; i++) {
            String[] str = br.readLine().split(" ");

            arr[Integer.parseInt(str[0]) - 1][Integer.parseInt(str[1]) - 1] = 1;
        }

        ArrayList<int[]> list = new ArrayList<>();

        int k = Integer.parseInt(br.readLine());

        for(int i = 0; i < k; i++) {
            String[] str = br.readLine().split(" ");

            int dir = str[1].charAt(0) == 'L' ? 1 : 2;

            list.add(new int[] { Integer.parseInt(str[0]), dir });
        }

        int x = 0; int y = 0;
        int[][] dxdy = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int time = 0;
        int dir = 0;
        int idx = 0;
        LinkedList<int[]> snake = new LinkedList<>();
        snake.add(new int[] { x, y });

        loop:
        while(true) {
            time++;
            x += dxdy[dir][0];
            y += dxdy[dir][1];

            if(x < 0 || x >= n || y < 0 || y >= n) break loop;

            snake.addFirst(new int[] { x, y });

            for(int i = 1; i < snake.size(); i++) {
                if(snake.get(i)[0] == x && snake.get(i)[1] == y) {
                    break loop;
                }
            }

            if(arr[x][y] == 0) {
                snake.removeLast();
            } else if(arr[x][y] == 1) {
                arr[x][y] = 0;
            }

            if(idx < list.size() && list.get(idx)[0] == time) {
                if(list.get(idx)[1] == 1) {
                    dir--;
                    if(dir == -1) dir = 3;
                } else {
                    dir++;
                    if(dir == 4) dir = 0;
                }
                idx++;
            }
        }

        System.out.println(time);

    }
}
