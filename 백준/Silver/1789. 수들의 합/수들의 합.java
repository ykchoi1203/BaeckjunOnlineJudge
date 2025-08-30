import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n  = sc.nextLong();

        int k = 1;
        int count = 0;

        while(n > k * 2L) {
            n -= k;
            k++;
            count++;
        }

        if(n != 0) count++;

        System.out.println(count);
    }
}
