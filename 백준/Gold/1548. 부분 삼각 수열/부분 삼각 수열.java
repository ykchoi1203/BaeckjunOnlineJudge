import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        if(n <= 2) {
            System.out.println(n);
            return;
        }

        int max = 0;

        for(int i = 0; i < n - 1; i++) {
            for(int j = n - 1; j > i + 1; j--) {
                if(arr[i] + arr[i + 1] > arr[j]) {
                    max = Math.max(max, j - i + 1);
                    break;
                }
            }
        }

        System.out.println(max == 0 ? 2 : max);

    }
}
