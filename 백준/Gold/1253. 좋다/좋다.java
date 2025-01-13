import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long[] arr = new long[sc.nextInt()];

        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr);
        int cnt = 0;

        if(arr.length < 3) {
            System.out.println(0);
            return;
        }

        for(int i=0; i<arr.length; i++) {
            int start = 0; int end = arr.length-1;

            while(start < end) {
                if(start == i) {
                    start++;
                }

                if(end == i) {
                    end--;
                }
                
                if(start >= end) break;
                
                long sum = arr[start] + arr[end];

                if(sum == arr[i]) {
                    cnt++;
                    break;
                }

                if(sum > arr[i]) {
                    end--;
                } else {
                    start++;
                }
            }

        }

        System.out.println(cnt);
    }
}