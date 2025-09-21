import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[3];
        arr[0] = 1;

        for(int i = 1; i <= n; i++) {
            arr[2] = arr[1];

            arr[1] = arr[0] + arr[2];
            arr[0] = arr[2];
        }

        System.out.println(arr[0] + " " + arr[1]);
    }
}