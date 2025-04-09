import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        long start = 0;
        long end = 0;

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            end += arr[i];
            start = Math.max(start, arr[i]);
        }

        while(start <= end) {
            long mid = (start + end) / 2;
            int cnt = 0;
            long money = 0;
            for(int i = 0; i < n; i++) {
                if(arr[i] > money) {
                    cnt++;
                    money = mid - arr[i];
                } else {
                    money -= arr[i];
                }

                if(cnt > m) {
                    break;
                }
            }

            if(cnt <= m) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        System.out.println(start);

    }
}
