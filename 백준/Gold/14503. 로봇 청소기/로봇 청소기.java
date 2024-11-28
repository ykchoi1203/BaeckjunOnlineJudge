import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());

        if(direction % 2 == 1) {
            direction = direction == 1 ? 3 : 1;
        }

        int[] directions = new int[] {0, 1, 2, 3, 0, 1, 2, 3};
        int[][] dxdy = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        int[][] arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        while(true) {
            if(arr[x][y] == 0) {
                arr[x][y] = 2;
                answer++;
            } else if(arr[x][y] == 1) {
                break;
            }

            boolean isGo = false;

            for(int i = direction + 1; i < direction + 5; i++) {
                if(arr[x + dxdy[directions[i]][0]][y + dxdy[directions[i]][1]] == 0) {
                    x += dxdy[directions[i]][0];
                    y += dxdy[directions[i]][1];
                    direction = directions[i];
                    isGo = true;
                    break;
                }
            }

            if(!isGo) {
                x += dxdy[directions[direction + 2]][0];
                y += dxdy[directions[direction + 2]][1];
            }
        }

        System.out.println(answer);
    }

}
