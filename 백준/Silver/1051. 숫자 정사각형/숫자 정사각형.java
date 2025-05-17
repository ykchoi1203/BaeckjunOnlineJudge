import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            String s = br.readLine();

            for(int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        int max = 1;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int k = 1; k < n - i && k < m - j; k++) {
                    if(arr[i][j] == arr[i][j + k] && arr[i][j] == arr[i + k][j] && arr[i][j] == arr[i + k][j + k]) {
                        max = Math.max(max, (k + 1) * (k + 1));
                    }
                }
            }
        }

        System.out.println(max);
    }
}
