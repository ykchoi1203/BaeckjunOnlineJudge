import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String[] arr = br.readLine().split(" ");
        int answer = n + 1;
        int sum = 0;
        int startIdx = 0;
        for(int i=0; i<n; i++) {
            sum += Integer.parseInt(arr[i]);
            if(sum >= k) {
                answer = Math.min(answer, i - startIdx + 1);

                while(startIdx <= i && sum >= k) {
                    sum -= Integer.parseInt(arr[startIdx]);
                    startIdx++;
                    if(sum >= k) {
                        answer = Math.min(answer, i - startIdx + 1);
                    }
                }
            }
        }

        System.out.println(answer == n + 1 ? 0 : answer);

    }
}
