import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());

        long min = 1;
        long max =  2000000000;
        boolean isTrue = false;

        long z = (m * 100) / n;

        while(min < max) {
            long mid = (min + max) / 2;

            if(z < ((m + mid) * 100) / (n + mid)) {
                max = mid;
                isTrue = true;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(isTrue ? max : -1);

    }
}
