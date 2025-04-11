import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        Electric[] e = new Electric[n];

        Arrays.fill(dp, 1);

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            e[i] = new Electric(a, b);
        }

        Arrays.sort(e);

        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(e[i].end > e[j].end) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for(int i=0; i<n; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(n - max);

    }

    static class Electric implements Comparable<Electric>{
        int start;
        int end;

        public Electric(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Electric o) {
            return this.start - o.start;
        }
    }
}