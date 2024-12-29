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
            String[] string = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(string[j]);
            }
        }

        int answer = 0;
        
        for(int i = 0; i < n; i++) {
            answer = Math.max(answer, arr[i][0]);
        }
        
        for(int i = 0; i < m; i++) {
            answer = Math.max(answer, arr[0][i]);
        }

        for(int i = 0; i < n + m - 1; i++) {
            for(int j = 0, k = i - j; j < n && k >= 0; j++, k--) {
                if(j+1 < n && k + 1 < m) {
                    arr[j + 1][k + 1] = getMin(arr, j, k);
                    answer = Math.max(answer, arr[j + 1][k + 1]);
                }
            }
        }

        System.out.println(answer * answer);
    }

    public static int getMin(int[][] arr, int i, int j) {
        if(arr[i+1][j+1] == 0) return 0;
        return Math.min(arr[i][j], Math.min(arr[i+1][j], arr[i][j+1])) + 1;
    }
}
