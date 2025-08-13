import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        a %= b;

        if(a == 0) {
            System.out.println(0);
            return;
        }

        while(true) {
            if(a < b) {
                if(c == 0) {
                    System.out.println(0);
                    return;
                }

                a *= 10;
            }

            c--;

            if(c == 0) {
                System.out.println(a / b);
                return;
            }

            a %= b;
            if(a == 0) {
                System.out.println(0);
                return;
            }
        }
    }
}