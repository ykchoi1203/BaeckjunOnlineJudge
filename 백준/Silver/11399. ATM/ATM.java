import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int m = sc.nextInt();
        
        int[] arr = new int[m];
        
        for(int i=0; i<m; i++) {
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);
        
        long answer = 0;
        
        for(int time : arr) {
            answer += time * m;
            m--;
        }
        
        System.out.println(answer);
        
    }
}
