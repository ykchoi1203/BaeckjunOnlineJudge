import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int idx = 0;

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long answer = 0;

        for(int i = 1; i <= arr[n-1]; i++) {
            long sum = 0;
            for(int j = idx; j < n; j++) {
                if(arr[j] < i) {
                    idx = j;
                    continue;
                }

                long curSum = (long)i * (arr[j] / i) * w - (arr[j] % i == 0 ? (long)((arr[j] / i) - 1) * c : (long)(arr[j] / i) * c);

                if(curSum < 0) continue;

                sum += curSum;

            }
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);

    }
}
