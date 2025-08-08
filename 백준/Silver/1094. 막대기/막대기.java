import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int x = sc.nextInt();
        
        int answer = 0;
        
        while(x > 1) {
            answer += x % 2;
            x /= 2;
        }
        
        System.out.println(answer + 1);
        
    }
}