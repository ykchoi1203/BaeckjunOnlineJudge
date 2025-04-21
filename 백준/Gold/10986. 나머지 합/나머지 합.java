import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] sums = new long[n + 1];
        int[] cnt = new int[m];
        long count = 0;

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            int k = Integer.parseInt(st.nextToken());

            sums[i + 1] = (sums[i] + k) % m;
            if(sums[i + 1] % m == 0) count++;

            cnt[(int)(sums[i + 1] % m)]++;
        }

        for(int i = 0; i < m; i++) {
            count += (cnt[i] - 1) * (long)cnt[i] / 2;
        }

        System.out.println(count);

    }
}
