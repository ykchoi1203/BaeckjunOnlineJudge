import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[m + 1];

        for(int i=2; i<=m; i++) {
            if(arr[i] == 0) {
                arr[i] = 1;
                for(int j = 2; j * i <= m; j++) {
                    if(arr[j] != 0) {
                        arr[j * i] = arr[j] + 1;
                    }
                }
            }
        }

        int cnt = 0;
        for(int i = n; i <= m; i++) {
            if(isPrime(arr[i])) cnt++;
        }

        System.out.println(cnt);

    }

    static boolean isPrime(int n) {
        if(n < 2) return false;
        else if(n == 2) return true;
        else if(n % 2 == 0) return false;

        for(int i=3; i <= Math.sqrt(n); i+=2) {
            if(n % i == 0) return false;
        }

        return true;
    }
}
