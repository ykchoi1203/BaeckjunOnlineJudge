import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(sc.readLine());

        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(sc.readLine());
        }

        Arrays.sort(arr);
        int sum = 0;
        int cnt = 0;
        for(int i= (int)Math.round(n * 0.15); i < n - (int)Math.round(n * 0.15); i++) {
            sum += arr[i];
            cnt++;
        }

        System.out.println(Math.round(sum / (double)cnt));

    }
}
