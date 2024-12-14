import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[][] arr = new long[n][2];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
        }

        int cnt = 0;

        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                for(int k=j+1;k<n;k++) {
                    long a = (arr[i][0] - arr[j][0]) * (arr[i][0] - arr[j][0]) + (arr[i][1] - arr[j][1]) * (arr[i][1] - arr[j][1]);
                    long b = (arr[j][0] - arr[k][0]) * (arr[j][0] - arr[k][0]) + (arr[j][1] - arr[k][1]) * (arr[j][1] - arr[k][1]);
                    long c = (arr[k][0] - arr[i][0]) * (arr[k][0] - arr[i][0]) + (arr[k][1] - arr[i][1]) * (arr[k][1] - arr[i][1]);

                    if(a == b + c || b == c + a || c == a + b) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);

    }
}
