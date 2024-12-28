import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] parent = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for(int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.add(new int[] {a, b, cost});

        }

        int answer = 0;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();

            if(getParent(cur[0], parent) != getParent(cur[1], parent)) {
                union(cur[0], cur[1], parent);
                answer += cur[2];
            }
        }

        System.out.println(answer);

    }

    public static int getParent(int x, int[] parent) {
        if(parent[x] == x) return x;
        return getParent(parent[x], parent);
    }

    public static void union(int x, int y, int[] parent) {
        x = getParent(x, parent);
        y = getParent(y, parent);

        if(parent[x] > parent[y]) {
            parent[x] = y;
        } else {
            parent[y] = x;
        }
    }
}
