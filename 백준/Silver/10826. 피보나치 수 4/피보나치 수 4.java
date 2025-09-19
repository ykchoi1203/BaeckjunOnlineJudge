import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        BigInteger a = BigInteger.valueOf(0);
        BigInteger b = BigInteger.valueOf(1);

        BigInteger[] arr = new BigInteger[n + 1];
        arr[0] = a;
        
        if(n == 0) {
            System.out.println(0);
            return;
        }
        arr[1] = b;

        for(int i=2; i <= n; i++)
            arr[i] = arr[i- 2].add(arr[i-1]);


        System.out.println(arr[n]);
    }
}