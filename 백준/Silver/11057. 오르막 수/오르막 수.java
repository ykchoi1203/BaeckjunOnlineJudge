import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n][10];

        for(int i = 0; i < 10; i++) {
            arr[0][i] = 1;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = 0; k <= j; k++) {
                    arr[i][j] += arr[i - 1][k];
                    arr[i][j] %= 10007;
                }
            }
        }

        int answer = 0;

        for(int i = 0; i < 10; i++) {
            answer += arr[n - 1][i];
            answer %= 10007;
        }

        System.out.println(answer);
    }
}
