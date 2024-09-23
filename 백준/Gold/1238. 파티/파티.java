import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        
        for(int i=1; i<=n; i++) {
            map.put(i, new HashMap<>());
        }
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            Map<Integer, Integer> curMap = map.get(start);
            
            if(curMap.containsKey(end)) {
                curMap.put(end, Math.min(curMap.get(end), cost));
            } else {
                curMap.put(end, cost);
            }
        }
        
        int max = 0;
        
        for(int i=1; i<=n; i++) {
            max = Math.max(getCost(map, i, x) + getCost(map, x, i), max);
        }
        
        System.out.println(max);
        
    }
    
    public static int getCost(Map<Integer, Map<Integer, Integer>> map, int start, int end) {
        if(start == end) return 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        queue.add(new int[] {start, 0});
        int[] visited = new int[map.size() + 1];
        
        Arrays.fill(visited, Integer.MAX_VALUE);
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(cur[0] == end) {
                return cur[1];
            }     
            
            Map<Integer, Integer> curMap = map.get(cur[0]);
            for(int key : curMap.keySet()) {
                if(visited[key] > cur[1] + curMap.get(key)) {
                    visited[key] = cur[1] + curMap.get(key);
                    queue.add(new int[] {key, cur[1] + curMap.get(key)});
                }
            }
            
        }
        
        return 0;
        
    }
}