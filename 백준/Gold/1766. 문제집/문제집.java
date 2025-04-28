import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int i=1; i<=n; i++) {
            map.put(i, new HashSet<>());
        }

        for(int i=1; i<=m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.get(a).add(b);
            arr[b]++;

        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=1; i<=n; i++) {
            if(arr[i] == 0) pq.add(i);
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()) {
            int cur = pq.poll();

            sb.append(cur).append(" ");

            for(int next : map.get(cur)) {
                if(arr[next] > 0) {
                    arr[next]--;

                    if(arr[next] == 0) pq.add(next);
                }
            }
        }

        System.out.println(sb);

    }
}
