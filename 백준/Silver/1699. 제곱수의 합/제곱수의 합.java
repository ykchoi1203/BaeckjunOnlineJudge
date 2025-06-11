import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n + 1];

        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[1] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = 1; j < Math.sqrt(i); j++) {
                arr[i] = Math.min(arr[i], arr[i - j * j] + 1);
            }
            if((int)Math.sqrt(i) * (int)Math.sqrt(i) == i) {
                arr[i] = 1;
            }
        }

        System.out.println(arr[n]);

    }

}
