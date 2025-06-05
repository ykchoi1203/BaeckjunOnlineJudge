import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int xs = Integer.parseInt(st.nextToken());
        int ys = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int xe = Integer.parseInt(st.nextToken());
        int ye = Integer.parseInt(st.nextToken());
        int dx = Integer.parseInt(st.nextToken());
        int dy = Integer.parseInt(st.nextToken());

        int k = gdc(dx, dy);

        dx /= k;
        dy /= k;

        long min = (xe - xs) * (long)(xe - xs) + (ye - ys) * (long)(ye - ys);

        while(true) {
            int nX = xe + dx;
            int nY = ye + dy;

            long newMin = (nX - xs) * (long)(nX - xs) + (nY - ys) * (long)(nY - ys);

            if(min < newMin) {
                break;
            }

            min = newMin;
            xe = nX;
            ye = nY;
        }

        System.out.println(xe + " " + ye);

    }

    public static int gdc(int x, int y) {
        if(y == 0) return x;
        return gdc(y, x % y);
    }
}
