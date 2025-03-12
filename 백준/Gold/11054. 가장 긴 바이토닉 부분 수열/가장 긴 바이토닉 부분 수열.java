import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(arr[i] > arr[j]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }

            for(int j=n-1; j > n - i - 1; j--) {
                if(arr[n-i-1] > arr[j]) {
                    dp2[n-i-1] = Math.max(dp2[n-i-1], dp2[j] + 1);
                }
            }
        }

        int answer = 0;

        for(int i=0; i<n; i++) {
            answer = Math.max(dp1[i] + dp2[i] - 1, answer);
        }

        System.out.println(answer);
    }
}
