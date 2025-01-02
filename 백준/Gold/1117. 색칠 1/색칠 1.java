import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long w = Long.parseLong(st.nextToken());
        long h = Long.parseLong(st.nextToken());
        long f = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long x1 = Long.parseLong(st.nextToken());
        long y1 = Long.parseLong(st.nextToken());
        long x2 = Long.parseLong(st.nextToken());
        long y2 = Long.parseLong(st.nextToken());

        long answer = w * h;

        long overlapedX = f >= (w+1) / 2 ? w - f: f;

        if(overlapedX >= x1 && overlapedX <= x2) {
            answer -= 2 * (overlapedX - x1) * (c + 1) * (y2 - y1);
            answer -= (x2 - overlapedX) * (y2 - y1) * (c + 1);
        } else if(overlapedX < x1) {
            answer -= (x2 - x1) * (y2 - y1) * (c + 1);
        } else {
            answer -= 2 * (x2 - x1) * (y2 - y1) * (c + 1);
        }

        System.out.println(answer);

    }
}
