import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[][] arr = new long[100001][3];
        arr[1][0] = 1;
        arr[2][1] = 1;
        arr[3][2] = 1;
        arr[3][0] = 1;
        arr[3][1] = 1;

        for(int i = 4; i < 100001; i++) {
            arr[i][0] += (arr[i-1][2] + arr[i-1][1]) % 1000000009;
            arr[i][1] += (arr[i-2][0] + arr[i-2][2]) % 1000000009;
            arr[i][2] += (arr[i-3][1] + arr[i-3][0]) % 1000000009;
        }

        while(n-- > 0) {
            int k = sc.nextInt();

            long answer = ((arr[k][0] + arr[k][1]) % 1000000009 + arr[k][2]) % 1000000009;
            System.out.println(answer);

        }
    }
}
