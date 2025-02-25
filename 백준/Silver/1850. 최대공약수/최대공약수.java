import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long m = sc.nextLong();

        System.out.println("1".repeat((int)gdc(n, m)));

    }

    public static long gdc(long a, long b) {
        if(a % b == 0) return b;
        return gdc(b, a % b);
    }
}
