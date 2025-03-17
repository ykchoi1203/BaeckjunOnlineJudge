import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        StringBuilder sb = new StringBuilder();

        if(n == 0) {
            System.out.println("0");
            return;
        }

        while(n != 0) {
            if(n % -2 == 0) {
                sb.append(0);
                n = n / -2;
            } else {
                sb.append(1);
                n = (n - 1) / -2;
            }
        }

        System.out.println(sb.reverse());
        
    }
}