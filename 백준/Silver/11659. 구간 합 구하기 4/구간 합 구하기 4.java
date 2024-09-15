import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int m = sc.nextInt();
        
        int n = sc.nextInt();
        
        long[] arr = new long[m + 1];
        
        for(int i=1; i<=m; i++) {
            arr[i] = arr[i-1] + sc.nextLong();
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
           
            sb.append((arr[end] - arr[start-1])).append("\n");
        }
        System.out.println(sb.toString());
    }
}