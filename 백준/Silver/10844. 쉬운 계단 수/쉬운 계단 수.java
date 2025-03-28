import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long answer = 0;
        int start = 1;

        while(start < n) {
            int a = start % 2 == 0 ? 0 : 1;
            int b = a == 0 ? 1 : 0;
            arr[a][0] = arr[b][1];
            for(int i=1; i<9; i++) {
                arr[a][i] = (arr[b][i-1] + arr[b][i + 1]) % 1000000000;
            }
            arr[a][9] = arr[b][8];
            start++;
        }



        for(int i=0; i<10; i++) {
            answer += arr[n % 2 == 1 ? 0 : 1][i];
            answer %= 1000000000;
        }
        System.out.println(answer);

    }

    static long[][] arr = new long[][] {{1, 1, 1, 1, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    static long[] arr2 = new long[10];
}
