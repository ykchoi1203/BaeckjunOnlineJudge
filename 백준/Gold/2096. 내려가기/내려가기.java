import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][][] arr = new int[2][n][3];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            if(i == 0) {
                for(int j=0; j<3; j++) {
                    arr[0][i][j] = Integer.parseInt(st.nextToken());
                    arr[1][i][j] = arr[0][i][j];
                }
            } else {
                for(int j=0; j<3; j++) {
                    arr[0][i][j] = Integer.parseInt(st.nextToken());
                    arr[1][i][j] = arr[0][i][j];
                }
                arr[0][i][0] += Math.max(arr[0][i-1][0], arr[0][i-1][1]);
                arr[0][i][1] += Math.max(arr[0][i-1][0], Math.max(arr[0][i-1][2], arr[0][i-1][1]));
                arr[0][i][2] += Math.max(arr[0][i-1][1], arr[0][i-1][2]);
                arr[1][i][0] += Math.min(arr[1][i-1][0], arr[1][i-1][1]);
                arr[1][i][1] += Math.min(arr[1][i-1][0], Math.min(arr[1][i-1][1], arr[1][i-1][2]));
                arr[1][i][2] += Math.min(arr[1][i-1][1], arr[1][i-1][2]);
            }
        }

        int max = Math.max(arr[0][n-1][0], Math.max(arr[0][n-1][1], arr[0][n-1][2]));
        int min = Math.min(arr[1][n-1][0], Math.min(arr[1][n-1][1], arr[1][n-1][2]));

        System.out.println(max + " " + min);

    }
}
