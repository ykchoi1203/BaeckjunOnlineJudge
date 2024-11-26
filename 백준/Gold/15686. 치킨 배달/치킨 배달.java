import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
                    home.add(new int[] {i, j});
                    continue;
                }

                if(arr[i][j] == 2) {
                    list.add(new int[] {i, j});
                }
            }
        }

        dfs(0, 0);

        System.out.println(answer);

    }

    static int[][] arr;
    static int n;
    static int m;
    static int answer = Integer.MAX_VALUE;
    static ArrayList<int[]> list = new ArrayList<>();
    static ArrayList<int[]> choose = new ArrayList<>();
    static ArrayList<int[]> home = new ArrayList<>();

    static void dfs(int idx, int size) {
        if(size == m) {
            getAnswer();
            return;
        }

        if(list.size() == idx) {
            return;
        }

        for(int i=idx; i<list.size(); i++) {
            choose.add(list.get(i));
            dfs(i + 1, size + 1);
            choose.remove(size);
        }
    }

    static void getAnswer() {
        int sum = 0;
        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for(int[] delivery : choose) {
            for(int[] cur : home) {
                dp[cur[0]][cur[1]] = Math.min(dp[cur[0]][cur[1]], Math.abs(delivery[0] - cur[0]) + Math.abs(delivery[1] - cur[1]));
            }
        }
        for(int[] cur : home) {
            sum += dp[cur[0]][cur[1]];
        }

        answer = Math.min(answer, sum);
    }

}

