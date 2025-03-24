import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][];
        isUsed = new boolean[n + 1];

        for(int i=0; i<n; i++) {
            arr[i] = new int[n - i];
        }

        dfs(0);
        System.out.println(answer);
    }

    static int[][] arr;
    static int n;
    static int m;
    static String answer;
    static boolean[] isUsed;

    static void dfs(int idx) {
        if(idx == n) {
            if(check()) {
                StringBuilder sb = new StringBuilder();
                for(int i=0; i<n; i++) {
                    sb.append(arr[0][i]).append(" ");
                }

                answer = sb.toString();
            }

            return;
        }

        for(int i=1; i<=n; i++) {
            if(!isUsed[i]) {
                isUsed[i] = true;
                arr[0][idx] = i;
                dfs(idx+1);
                isUsed[i] = false;
                if(answer != null) return;
            }
        }
    }

    static boolean check() {
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < n - i; j++) {
                arr[i][j] = arr[i-1][j] + arr[i-1][j + 1];
            }
        }

        return arr[n-1][0] == m;
    }
}
