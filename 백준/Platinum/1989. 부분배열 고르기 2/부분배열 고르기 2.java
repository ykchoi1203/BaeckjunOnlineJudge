import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new long[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        sol(0, n-1);
        System.out.println(result);
        System.out.println((x+1) + " " + (y+1));
    }

    static long[] arr;
    static int x = 0;
    static int y = 0;
    static long result = -1;

    public static long sol(int start, int end) {
        if(start == end) {
            if(arr[start] * arr[start] > result) {
                result = arr[start] * arr[start];
                x = start;
                y = start;
            }
            return result;
        }

        int mid = (start + end) / 2;
        long leftSum = sol(start, mid);
        long rightSum = sol(mid+1, end);

        if(leftSum > result) {
            result = leftSum;
            x = start;
            y = mid;
        }
        if(rightSum > result) {
            result = rightSum;
            x = mid+1;
            y = end;
        }

        int left = mid;
        int right = mid+1;

        long hab = arr[left] + arr[right];
        long min = Math.min(arr[left], arr[right]);

        if(result < hab * min) {
            result = hab * min;
            x = left;
            y = right;
        }

        while(start < left || right < end) {
            if(right < end && (start == left || arr[left-1] < arr[right + 1])) {
                right++;
                hab += arr[right];
                min = Math.min(min, arr[right]);
            } else {
                left--;
                hab += arr[left];
                min = Math.min(min, arr[left]);
            }

            if(result < hab * min) {
                result = hab * min;
                x = left;
                y = right;
            }
        }

        return result;
    }
}
