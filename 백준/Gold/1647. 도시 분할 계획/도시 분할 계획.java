import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] parents = new int[n+1];

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=1; i<=n; i++) {
            parents[i] = i;
            map.put(i, 1);
        }


        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());

            queue.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        int answer = 0;

        while(map.size() > 2 && !queue.isEmpty()) {
            int[] cur = queue.poll();

            answer = unions(parents, cur[0], cur[1], map, answer, cur[2]);
        }

        System.out.println(answer);

    }

    public static int getParent(int[] parent, int x) {
        if(parent[x] != x) {
            parent[x] = getParent(parent, parent[x]);
        }

        return parent[x];
    }

    public static int unions(int[] parent, int x, int y, Map<Integer, Integer> map, int answer, int weight) {
        x = getParent(parent, x);
        y = getParent(parent, y);


        if(x > y) {
            parent[x] = y;
            map.put(y, map.get(y) + map.get(x));
            answer += weight;
            map.remove(x);
        } else if(x < y) {
            parent[y] = x;
            map.put(x, map.get(y) + map.get(x));
            map.remove(y);
            answer += weight;
        }

        return answer;
    }
}
