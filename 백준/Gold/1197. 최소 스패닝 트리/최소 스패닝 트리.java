import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        
        for(int i=1; i<=n; i++) {
            map.put(i, new HashMap<>());
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            pq.add(new int[] {start, end, cost});
        }
        
        int[] visited = new int[n+1];
        
        for(int i=0; i<n+1; i++) {
            visited[i] = i;
        }
        
        int answer = 0;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            if(getParent(cur[0], visited) != getParent(cur[1], visited)) {
                unionParent(visited, cur[0], cur[1]);
                answer += cur[2];
            }
        }
        
        System.out.println(answer);
        
    }
    
    public static int getParent(int x, int[] visited) {
        if(visited[x] != x) {
            visited[x] = getParent(visited[x], visited);
        }
        
        return visited[x];
    }
    
    public static void unionParent(int[] visited, int a, int b) {
        a = getParent(a, visited);
        b = getParent(b, visited);
        
        if(a > b) {
            visited[a] = b;
        } else {
            visited[b] = a;
        }
    }
}