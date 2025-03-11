import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        int max = 0;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max += arr[i][j];
            }
        }

        max += k;

        max /= n * m;
        
        max = Math.min(max, 256);

        int answer = Integer.MAX_VALUE;
        int height = 0;

        for(int l = max; l >= 0; l--) {
            int cnt = k;
            int time = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(arr[i][j] < l) {
                        cnt -= l - arr[i][j];
                        time += (l - arr[i][j]);
                    } else if(arr[i][j] > l) {
                        cnt += arr[i][j] - l;
                        time += (arr[i][j] - l) * 2;
                    }
                }
            }

            if(cnt < 0) continue;

            if(time < answer) {
                answer = time;
                height = l;
            }
        }

        System.out.println(answer + " " + height);
    }
}
