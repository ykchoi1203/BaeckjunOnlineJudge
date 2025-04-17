import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        backtrack(0, 0);
        if(m == 0) cnt--;
        System.out.println(cnt);
    }

    static int[] arr;
    static int m;
    static int cnt = 0;
    static void backtrack(int idx, long sum) {
        if(idx == arr.length) {
            if(sum == m) {
                cnt++;
            }
            return;
        }

        backtrack(idx + 1, sum + arr[idx]);
        backtrack(idx + 1, sum);
    }
}
