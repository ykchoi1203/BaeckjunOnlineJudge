import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] dp = new int[101];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        dp[1] = 0;

        Map<Integer, Integer> snake = new HashMap<>();
        Map<Integer, Integer> ladder = new HashMap<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            ladder.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());

            snake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int i=1; i<=6 && cur + i <= 100; i++) {
                if(snake.containsKey(cur + i) && dp[snake.get(cur + i)] > dp[cur] + 1) {
                    dp[snake.get(cur + i)] = dp[cur] + 1;
                    queue.add(snake.get(cur + i));
                    continue;
                } else if(snake.containsKey(cur + i)) {
                    continue;
                }

                if(ladder.containsKey(cur + i) && dp[ladder.get(cur + i)] > dp[cur] + 1) {
                    dp[ladder.get(cur + i)] = dp[cur] + 1;
                    queue.add(ladder.get(cur + i));
                    continue;
                } else if(ladder.containsKey(cur + i)) {
                    continue;
                }

                if(dp[cur + i] > dp[cur] + 1) {
                    dp[cur + i] = dp[cur] + 1;
                    queue.add(cur + i);
                }
            }
        }

        System.out.println(dp[100]);

    }
}
