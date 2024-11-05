import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        if(n >= m) {
            System.out.println(n - m);
            System.out.println(1);
            return;
        }

        boolean[] visited = new boolean[2 * (m+1)];
        int min = Integer.MAX_VALUE;
        int answer = 0;

        int[] dp = new int[visited.length];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[n] = 0;

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {n, 0});
        visited[n] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            if(cur[0] == m && min == cur[1]) {
                answer++;
            } else if(cur[0] == m && min > cur[1]) {
                min = cur[1];
                answer = 1;
            } else if(min < cur[1]) {
                break;
            }

            if(cur[0] - 1 >= 0 && !visited[cur[0] - 1]) {
                visited[cur[0] - 1] = true;
                dp[cur[0] - 1] = cur[1] + 1;
                queue.add(new int[] {cur[0] - 1, cur[1] + 1});
            } else if(cur[0] - 1 >= 0 && visited[cur[0] - 1] && dp[cur[0] - 1] == cur[1] + 1) {
                queue.add(new int[] {cur[0] - 1, cur[1] + 1});
            }

            if(cur[0] + 1 < visited.length && !visited[cur[0] + 1]) {
                visited[cur[0] + 1] = true;
                dp[cur[0] + 1] = cur[1] + 1;
                queue.add(new int[] {cur[0] + 1, cur[1] + 1});
            } else if(cur[0] + 1 < visited.length && visited[cur[0] + 1] && dp[cur[0] + 1] == cur[1] + 1) {
                queue.add(new int[] {cur[0] + 1, cur[1] + 1});
            }

            if(cur[0] * 2 < visited.length && !visited[cur[0] * 2]) {
                visited[cur[0] * 2] = true;
                dp[cur[0] * 2] = cur[1] + 1;
                queue.add(new int[] {cur[0] * 2, cur[1] + 1});
            } else if(cur[0] * 2 < visited.length && visited[cur[0] * 2] && dp[cur[0] * 2] == cur[1] + 1) {
                queue.add(new int[] {cur[0] * 2, cur[1] + 1});
            }
        }

        System.out.println(min);
        System.out.println(answer);

    }
}