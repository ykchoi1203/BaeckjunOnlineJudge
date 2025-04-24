import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] visited = new int[n + 1];

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if(!map.containsKey(a)) {
                map.put(a, new HashMap<>());
            }

            if(!map.get(a).containsKey(b)) {
                map.get(a).put(b, 0);
            }

            if(!map.containsKey(b)) {
                map.put(b, new HashMap<>());
            }

            if(!map.get(b).containsKey(a)) {
                map.get(b).put(a, 0);
            }

            map.get(a).put(b, Math.max(weight, map.get(a).get(b)));
            map.get(b).put(a, Math.max(weight, map.get(b).get(a)));
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for(int key : map.get(start).keySet()) {
            q.add(new int[] {key, map.get(start).get(key)});
        }

        visited[start] = Integer.MAX_VALUE;
        int answer = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[0] == end) {
                answer = Math.max(cur[1], answer);
                break;
            }

            for(int key : map.get(cur[0]).keySet()) {
                if(visited[key] < Math.min(cur[1], map.get(cur[0]).get(key))) {
                    visited[key] = Math.min(cur[1], map.get(cur[0]).get(key));
                    q.add(new int[] {key, visited[key]});
                }
            }
        }

        System.out.println(answer);

    }
}
