import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        long answer = 665;
        
        while(n > 0) {
            answer++;
            if(Long.toString(answer).contains("666")) {
                n--;
            }
        }
        
        System.out.print(answer);
    }
}