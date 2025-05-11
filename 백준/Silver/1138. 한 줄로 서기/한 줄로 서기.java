import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        answer = new int[n];
        dp = new int[n];
        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        for(int i = 0; i < n; i++) {
            System.out.print((answer[i] + 1) + " ");
        }


    }

    static int[] arr;
    static int[] dp;
    static int[] answer;
    static boolean[] visited;
    static int n;
    static boolean isTrue;

    static void dfs(int idx) {
        if(idx == n) {
            for(int i = 0; i < n; i++) {
                if(dp[i] != arr[i]) return;
            }

            isTrue = true;
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                answer[idx] = i;
                dp[i] = 0;
                for(int j = 0; j < idx; j++) {
                    if(answer[j] > answer[idx]) {
                        dp[i]++;
                    }
                }

                if(dp[i] != arr[i]) {
                    visited[i] = false;
                    dp[i] = 0;
                    continue;
                }

                dfs(idx+1);
                if(isTrue) return;
                visited[i] = false;
            }
        }

    }
}
