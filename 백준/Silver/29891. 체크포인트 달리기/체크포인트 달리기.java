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
        while(arr[idx] <= 0 && idx + k < n && arr[idx + k] <= 0) {
            answer += Math.abs(arr[idx] * 2);
            idx += k;
        }
        
        if(arr[idx] < 0) {
            answer += Math.abs(arr[idx] * 2);
        }
        
        int plusIdx = n-1;
        
        while(arr[plusIdx] > 0 && plusIdx - k >= 0 && arr[plusIdx - k] >= 0) {
            answer += arr[plusIdx] * 2;
            plusIdx -= k;
        }
        
        if(arr[plusIdx] > 0) {
            answer += arr[plusIdx] * 2;
        }
        
        System.out.println(answer);
        
    }
}