import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[] cnt = new int[100001];
        int[] arr = new int[n];
        
        for(int i=0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int start = 0;
        int curIdx = 0;
        int max = 0;
        
        while(curIdx < n) {
            cnt[arr[curIdx]]++;
            
            while(start <= curIdx && cnt[arr[curIdx]] > k) {
                cnt[arr[start]]--;
                start++;
            }
            
            max = Math.max(max, curIdx - start + 1);
            curIdx++;
        }
        
        System.out.println(max);
        
    }
}