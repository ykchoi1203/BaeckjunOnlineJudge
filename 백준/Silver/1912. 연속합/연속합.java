import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = arr[0];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            answer = Math.max(answer, sum);

            if(sum < 0) sum = 0;
        }

        System.out.println(answer);
    }
}
