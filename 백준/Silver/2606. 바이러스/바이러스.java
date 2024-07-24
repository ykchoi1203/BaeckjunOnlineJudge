import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[N+1];
        
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i=1; i<=N; i++) {
            map.put(i, new ArrayList<>());
        }
        
        
        for(int i = 0; i<K; i++) {
            String[] cur = br.readLine().split(" ");
            
            map.get(Integer.parseInt(cur[0])).add(Integer.parseInt(cur[1]));
            map.get(Integer.parseInt(cur[1])).add(Integer.parseInt(cur[0]));
        }
        
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(1);
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            
            if(!visited[cur]) {
                for(int next : map.get(cur)) {
                    if(!visited[next]) {
                        queue.add(next);
                    }
                }
                visited[cur] = true;
                answer++;
            }
        }
        
        System.out.println(answer-1);
        
    }
}