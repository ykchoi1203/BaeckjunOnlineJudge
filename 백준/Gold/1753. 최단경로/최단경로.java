import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] NM = br.readLine().split(" ");
        int n = Integer.parseInt(NM[0]);
        int m = Integer.parseInt(NM[1]);
        
        int[] arr = new int[n+1];
        
        Arrays.fill(arr, Integer.MAX_VALUE);
        
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        
        int start = Integer.parseInt(br.readLine());
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        pq.add(new int[] {start, 0});
        
        for(int i=0; i<m; i++) {
            String[] link = br.readLine().split(" ");
            int u = Integer.parseInt(link[0]);
            int v = Integer.parseInt(link[1]);
            int w = Integer.parseInt(link[2]);
            
            if(!map.containsKey(u)) {
                map.put(u, new HashMap<>());
            }
            if(!map.get(u).containsKey(v)) {
                map.get(u).put(v, w);
            } else {
                map.get(u).put(v, Math.min(map.get(u).get(v), w));
            }
        }
        
        arr[start] = 0;
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            if(map.containsKey(cur[0])) {
                Map<Integer, Integer> nextMap = map.get(cur[0]);
                for(int next : nextMap.keySet()) {
                    if(arr[next] > nextMap.get(next) + cur[1]) {
                        pq.add(new int[] {next, cur[1] + nextMap.get(next)});
                        arr[next] = cur[1] + nextMap.get(next);
                    }
                }
            }
        }
        
        for(int i=1; i<= n; i++) {
            if(arr[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(arr[i]);
            }
        } 
    }
}
