import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for(int i=1; i<=n; i++) {
            map.put(i, new HashMap<>());
        }

        for(int i=0; i<k; i++) {
            String[] cur = br.readLine().split(" ");

            Map<Integer, Integer> curMap = map.get(Integer.parseInt(cur[0]));
            if(curMap.containsKey(Integer.parseInt(cur[1]))) {
                curMap.put(Integer.parseInt(cur[1]), Math.min(curMap.get(Integer.parseInt(cur[1])), Integer.parseInt(cur[2])));
            } else {
                curMap.put(Integer.parseInt(cur[1]), Integer.parseInt(cur[2]));
            }
        }

        String[] startEnd = br.readLine().split(" ");
        int start = Integer.parseInt(startEnd[0]);
        int end = Integer.parseInt(startEnd[1]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] visited = new int[n+1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        pq.add(new int[] {start, 0});
        visited[start] = 0;
        int answer = 0;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();

            if(cur[0] == end) {
                answer = cur[1];
                break;
            }

            for(int key : map.get(cur[0]).keySet()) {
                if(visited[key] > cur[1] + map.get(cur[0]).get(key)) {
                    visited[key] = cur[1] + map.get(cur[0]).get(key);
                    pq.add(new int[] {key, visited[key]});
                }
            }
        }

        System.out.println(answer);

    }
}