import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {
            while(!pq.isEmpty() && pq.peek()[0] < i - m + 1) {
                pq.poll();
            }

            int k = Integer.parseInt(st.nextToken());

            if(!pq.isEmpty() && pq.peek()[1] >= k) {
                pq.clear();
            }

            pq.add(new int[] {i, k});

            sb.append(pq.peek()[1]).append(" ");

        }

        System.out.println(sb);

    }
}
