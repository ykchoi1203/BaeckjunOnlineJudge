import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int s = sc.nextInt();
        int k = sc.nextInt();
        
        int n = s / k;
        int m = s % k;
        
        long answer = 1;
        
        while(k-- > 0) {
            if(m > 0) {
                answer *= n + 1;
                m--;
            } else {
                answer *= n;
            }
        }
        
        System.out.println(answer);
        
    }
}