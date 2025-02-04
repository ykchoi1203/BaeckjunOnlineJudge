import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();

        long[] arr = new long[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr);

        long min = 1;
        long max = arr[n-1];
        long answer = 0;

        while(min <= max) {
            int cnt = c - 1;

            long mid = (min + max) / 2;
            int idx = 0;

            long maxLen = Long.MAX_VALUE;

            for(int i=1; i<n; i++) {
                if(arr[i] - arr[idx] >= mid) {
                    cnt--;
                    maxLen = Math.min(maxLen, arr[i] - arr[idx]);
                    idx = i;
                }
            }

            if(cnt > 0) {
                max = mid - 1;
            } else {
                answer = Math.max(answer, maxLen);
                min = mid + 1;
            }

        }

        System.out.println(answer);

    }
}
