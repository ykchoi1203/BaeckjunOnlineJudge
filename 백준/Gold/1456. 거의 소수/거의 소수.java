import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();

        int cnt = 0;

        boolean[] isPrime = new boolean[(int) Math.sqrt(b)+1];

        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i < isPrime.length; i++) {
            if(isPrime[i]) {
                for(int j = i * 2; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for(int i = 2; i < isPrime.length; i++) {
            if(isPrime[i]) {
                long temp = i;

                while(temp <= (double) b / i) {
                    if(temp >= (double) a / i) {
                        cnt++;
                    }
                    temp *= i;
                }
            }
        }

        System.out.println(cnt);

    }

}
