import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        long[] arr = new long[n];
        
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextLong();
        }
        
        long answer = 0;
        Arrays.sort(arr);
        
        int idx = 0;
        
        while(idx < n - k + 1) {
            if(arr[idx] <= 0 && arr[idx + k - 1] <= 0) {
                answer += Math.abs(arr[idx]) * 2;
            } else if(arr[idx] >= 0 && arr[idx + k - 1] >= 0) {
                answer += arr[idx + k - 1] * 2;
            } else {
                answer += Math.abs(arr[idx]) * 2 + arr[idx + k - 1] * 2;
            }
            
            idx += k;
        }
        
        if(idx < n - 1) {
            if(arr[idx] <= 0 && arr[n - 1] <= 0) {
                answer += Math.abs(arr[idx]) * 2;
            } else if(arr[idx] >= 0 && arr[n - 1] >= 0) {
                answer += arr[n - 1] * 2;
            } else {
                answer += Math.abs(arr[idx]) * 2 + arr[n - 1] * 2;
            }
        }
        
        System.out.println(answer);
        
    }
}