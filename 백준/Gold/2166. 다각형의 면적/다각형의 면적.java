import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        long[][] arr = new long[n+1][2];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
        }
        
        arr[n][0] = arr[0][0];
        arr[n][1] = arr[0][1];
        
        double answer = 0;

        for(int i=0; i<n; i++) {
            answer += (double)arr[i][0] * arr[i+1][1];
            answer -= (double)arr[i][1] * arr[i+1][0];
        }

        System.out.printf("%.1f", Math.abs(answer / 2));

    }
}
