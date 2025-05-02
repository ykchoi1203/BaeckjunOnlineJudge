import java.io.* ;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int cnt = 0;

        for(int i = 0; i < n; i++) {
            while(!pq.isEmpty() && pq.peek() <= arr[i][0]) {
                pq.poll();
            }

            pq.add(arr[i][1]);
            cnt = Math.max(cnt, pq.size());
        }

        System.out.println(cnt);
    }
}
