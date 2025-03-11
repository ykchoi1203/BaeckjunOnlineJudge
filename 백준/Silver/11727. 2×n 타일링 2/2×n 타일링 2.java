import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int a = 1;
        int b = 3;
//        1     2   3     4    5
//        1 -> 3 -> 5 -> 11 -> 21 ->

        for(int i=0; i<n-2; i++) {
            int temp = (2 * a + b) % 10007;
            a = b;
            b = temp;
        }

        System.out.println(n == 1 ? 1 : b);
    }
}