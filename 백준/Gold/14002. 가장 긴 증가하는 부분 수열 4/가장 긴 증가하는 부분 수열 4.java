import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];
        String[] str = new String[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            str[i] = Integer.toString(arr[i]);
        }
        Arrays.fill(dp, 1);

        int max = 1;
        int idx = 0;

        for(int i = 1; i < n; i++) {
            for(int j=0; j < i; j++) {
                if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    str[i] = str[j] + " " + arr[i];

                    if(max < dp[i]) {
                        max = dp[i];
                        idx = i;
                    }
                }
            }
        }
        System.out.println(max);

        System.out.println(str[idx]);
    }
}
