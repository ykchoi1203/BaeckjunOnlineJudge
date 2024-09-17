import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] arr = new int[sc.nextInt()];
        
        for(int i=0; i<arr.length; i++) {
            arr[0] = i;
            dfs(arr, 1);
        }
        
        System.out.println(answer);
        
    }
    
    static int answer = 0;
    
    public static void dfs(int[] arr, int idx) {
        if(idx == arr.length) {
            answer++;
            return;
        }
        
        for(int i=0; i<arr.length; i++) {
            boolean isTrue = true;
            
            for(int j=idx-1; j >= 0; j--) {
                if(arr[j] == i || Math.abs(i - arr[j]) == idx - j) {
                    isTrue = false;
                    break;
                }
            }
            
            if(isTrue) {
                arr[idx] = i;
                dfs(arr, idx + 1);
            }
        }
        
    }
}