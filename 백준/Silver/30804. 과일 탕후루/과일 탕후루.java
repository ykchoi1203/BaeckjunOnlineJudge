import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[10];
        int count = 0;
        
        int startIdx = 0;
        int answer = 0;
        
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        
        for(int i=0; i<n; i++) {
            if(dp[arr[i]] == 0) {
                count++;
            }
            dp[arr[i]]++;
            
            while(count > 2) {
                dp[arr[startIdx]]--;
                if(dp[arr[startIdx]] == 0)
                    count--;
                startIdx++;
            }
            
            answer = Math.max(answer, i - startIdx + 1);
        }
        
        System.out.println(answer);
    }
}