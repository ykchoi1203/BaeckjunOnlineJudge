import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int d = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();

        if(d % p == 0 || d % q == 0 || p == 1 || q == 1) {
            System.out.println(d);
            return;
        }
        
        int temp = Math.min(p, q);
        p = Math.max(p, q);
        q = temp;
        
        long answer = (long)(d / p + 1) * p;

        int a = 0;

        while(a <= d / p + 1 && a <= q) {
            long pSum = (long) a * p;
            long qSum = pSum > d ? 0 : (d - pSum) % q == 0 ? (d - pSum) : ((d - pSum) / q + 1 ) * q;

            if(pSum + qSum == d) {
                System.out.println(d);
                return;
            }

            answer = Math.min(pSum + qSum, answer);
            a++;
        }

        System.out.println(answer);

    }
}