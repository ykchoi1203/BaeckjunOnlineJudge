import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[100][100];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            for(int j = x1; j <= x2; j++) {
                for(int k = y1; k <= y2; k++) {
                    arr[j][k]++;
                }
            }
        }

        int answer = 0;

        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(arr[i][j] > m)
                    answer++;
            }
        }

        System.out.println(answer);
    }
}