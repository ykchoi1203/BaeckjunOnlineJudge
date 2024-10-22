import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] sizes = br.readLine().split(" ");
        String[] costs = br.readLine().split(" ");

        int[][] dp = new int[2][m + 1];

        Arrays.fill(dp[0], Integer.MAX_VALUE);
        Arrays.fill(dp[1], Integer.MAX_VALUE);

        dp[0][0] = 0;
        dp[1][0] = 0;
        int sum = 0;

        for(int i=0; i<n; i++) {
            Program program = new Program(Integer.parseInt(sizes[i]), Integer.parseInt(costs[i]));
            int dpIdx = i % 2;
            int saveIdx = dpIdx == 0 ? 1 : 0;

            if(program.size >= m) {
                dp[saveIdx][m] = Math.min(dp[saveIdx][m], program.cost);
                continue;
            }

            for(int j=0; j<=sum && j <= m; j++) {
                if(dp[dpIdx][j] != Integer.MAX_VALUE) {
                    if(j + program.size <= m && dp[dpIdx][j] + program.cost < dp[saveIdx][j + program.size]) {
                        dp[saveIdx][j + program.size] = dp[dpIdx][j] + program.cost;
                    } else if(j + program.size > m && dp[dpIdx][j] + program.cost < dp[saveIdx][m]) {
                        dp[saveIdx][m] = dp[dpIdx][j] + program.cost;
                    }

                    if(dp[dpIdx][j] < dp[saveIdx][j]) {
                        dp[saveIdx][j] = dp[dpIdx][j];
                    }
                }
            }

            sum += program.size;
        }

        System.out.println(Math.min(dp[0][m], dp[1][m]));

    }

    public static class Program implements Comparable<Program> {
        int size;
        int cost;

        public Program(int size, int cost) {
            this.size = size;
            this.cost = cost;
        }

        @Override
        public int compareTo(Program p) {
            if(p.cost != cost) {
                return cost;
            }

            return p.size - size;
        }
    }
}
