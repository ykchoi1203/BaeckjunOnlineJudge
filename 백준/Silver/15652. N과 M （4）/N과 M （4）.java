import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] arr = new int[m];
        sb = new StringBuilder();
        
        dfs(arr, 0, n);
        
        System.out.print(sb.toString());
    }
    
    static StringBuilder sb;
    
    public static void dfs(int[] arr, int idx, int n) {
        if(arr.length == idx) {
            for(int number : arr)
                sb.append(number).append(" ");
            sb.append("\n");
            return;
        }
        
        for(int i = idx == 0 ? 1 : arr[idx-1]; i<=n; i++) {
            arr[idx] = i;
            dfs(arr, idx+1, n);
        }
    }
}