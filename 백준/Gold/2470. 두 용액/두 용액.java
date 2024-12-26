import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = n-1;

        int minLeft = 0;
        int minRight = 0;
        int min = Integer.MAX_VALUE;

        while(left < right) {
            if(min > Math.abs(arr[right] + arr[left])) {
                min = Math.abs(arr[right] + arr[left]);
                minLeft = left;
                minRight = right;
            }

            if(Math.abs(arr[left]) > Math.abs(arr[right])) {
                left++;
            } else if(Math.abs(arr[left]) < Math.abs(arr[right])) {
                right--;
            } else {
                break;
            }
        }

        System.out.println(arr[minLeft] + " " + arr[minRight]);

    }
}
