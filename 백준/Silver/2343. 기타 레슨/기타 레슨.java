import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        long max = 0;

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            max += arr[i];
        }

        long min = 0;
        long answer = Long.MAX_VALUE;

        loop:
        while(min < max) {
            long mid = (max + min) / 2;

            long sum = 0;
            int count = 0;

            for(int i=0; i<n; i++) {
                if(arr[i] > mid) {
                    min = mid + 1;
                    continue loop;
                }
                if(sum + arr[i] <= mid) {
                    sum += arr[i];
                } else {
                    sum = arr[i];
                    count++;
                }
            }

            if(sum > 0) count++;

            if(count > m) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        System.out.println(max);

    }
}
