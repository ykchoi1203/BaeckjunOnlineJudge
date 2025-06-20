import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[10001];

        boolean[] prime = new boolean[10001];

        prime[2] = true;

        for(int i = 3; i <= 10000; i+=2) {
            if(isPrime(i)) {
                prime[i] = true;
            }
        }

        for(int i = 4; i <= 10000; i+=2) {
            if(prime[i - 2]) {
                arr[i] = 2;
            }

            for(int j = (i / 2) % 2 == 0 ? i / 2 - 1 : i / 2 ; j > 2; j-=2) {
                if(prime[j] && prime[i - j]) {
                    arr[i] = j;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while(n-- > 0) {
            int num = sc.nextInt();

            sb.append(arr[num]).append(" ").append(num - arr[num]).append("\n");
        }

        System.out.println(sb);
    }

    static boolean isPrime(int n) {
        for(int i = 3; i <= Math.sqrt(n); i += 2) {
            if(n % i == 0) return false;
        }

        return true;
    }

}
