import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        long l = 1, r = 0;
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            r = Math.max(r, arr[i]);
        }
        
        int answer = 0;
        
        while(l <= r) {
            long mid = (l + r) / 2;
            long cnt = 0;
            for(int i=0; i<n; i++) {
                cnt += arr[i] / mid;
            }
            
            if(cnt >= k) {
                answer = Math.max(answer , (int)mid);
                l = mid + 1;
                
            } else {
                r = mid - 1;
            }
        }
        
        System.out.println(answer);
        
    }
}