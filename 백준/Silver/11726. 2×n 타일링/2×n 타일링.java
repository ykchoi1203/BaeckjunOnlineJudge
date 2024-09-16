import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int a = 1;
        int b = 1;
        
        for(int i = 2; i <= n; i++) {
            int temp = b;
            b = (a + b) % 10007;
            a = temp;
        }
        
        System.out.println(b);
    }
}