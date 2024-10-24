import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        arr2 = new int[n];
        int max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            arr2[i] = arr[i];

            max = Math.max(max, arr[i]);
        }

        dp = new int[max + 1];
        visited = new boolean[max + 1];
        Arrays.sort(arr2);

        for(int i = n-1; i >=0; i--) {
            prime(arr2[i]);
            visited[arr2[i]] = true;
        }

        StringBuilder sb = new StringBuilder();

        for(int num : arr) {
            sb.append(dp[num]).append(" ");
        }

        System.out.println(sb.toString());

    }

    static int[] dp;
    static int[] arr2;
    static boolean[] visited;

    public static void prime(int n) {
        for(int i = n * 2; i < dp.length; i+=n) {
            if(visited[i]) {
                dp[i]--;
                dp[n]++;
            }
        }
    }
}
