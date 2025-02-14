import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[] dp = new int[n];
        boolean[] visited = new boolean[n];

        long answer = 0;

        Arrays.fill(dp, Integer.MAX_VALUE);

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.add(new int[] {0, 0});


        while(!pq.isEmpty()) {
            int[] cur = pq.poll();

            if(dp[cur[0]] <= cur[1]) {
                continue;
            }

            dp[cur[0]] = cur[1];
            visited[cur[0]] = true;

            for(int i=0; i<n; i++) {
                if(i != cur[0] && !visited[i]) {
                    pq.add(new int[] {i, arr[cur[0]][i]});
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            answer += dp[i];
        }
        System.out.println(answer);
    }
}
