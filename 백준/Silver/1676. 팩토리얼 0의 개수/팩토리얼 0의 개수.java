import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[2];

        for(int i = 2; i <= n; i++) {
            int num = i;
            while(num > 1 && num % 5 == 0) {
                num /= 5;
                arr[1]++;
            }

            while(num > 1 && num % 2 == 0) {
                num /= 2;
                arr[0]++;
            }
        }

        System.out.println(Math.min(arr[0], arr[1]));
    }
}
