import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n + 1];
        arr[0] = 2;

        for(int i=0; i<=n; i++) {
            if(i + 1 <= n && arr[i + 1] == 0) {
                arr[i + 1] = arr[i] == 2 ? 1 : 2;
            }

            if(i + 3 <= n && arr[i + 3] == 0) {
                arr[i + 3] = arr[i] == 2 ? 1 : 2;
            }
        }

        System.out.println(arr[n] == 2 ? "SK" : "CY");
    }
}