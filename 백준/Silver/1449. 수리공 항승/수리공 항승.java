import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int l = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int cnt = 0;

        for(int i = 0; i < n; i++) {
            int lastIdx = i;

            for(int j = i + 1; j < n && arr[j] - arr[i] + 1 <= l; j++) {
                lastIdx = j;
            }

            i = lastIdx;
            cnt++;

        }

        System.out.println(cnt);


    }
}
