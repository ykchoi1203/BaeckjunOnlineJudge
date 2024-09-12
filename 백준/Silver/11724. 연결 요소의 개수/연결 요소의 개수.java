import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] NM = br.readLine().split(" ");
        
        int n = Integer.parseInt(NM[0]);
        int m = Integer.parseInt(NM[1]);
        
        boolean[] visited = new boolean[n];
        
        ArrayList<Set<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            list.add(new HashSet<Integer>());
        }
        
        for(int i = 0; i < m; i++) {
            String[] cur = br.readLine().split(" ");
            int a = Integer.parseInt(cur[0]);
            int b = Integer.parseInt(cur[1]);
            list.get(a-1).add(b-1);
            list.get(b-1).add(a-1);
        }
        
        int cnt = 0;
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                
                Queue<Integer> queue = new LinkedList<>();
                
                queue.add(i);
                
                while(!queue.isEmpty()) {
                    int cur = queue.poll();
                    
                    for(int next : list.get(cur)) {
                        if(!visited[next]) {
                            visited[next] = true;
                            queue.add(next);
                        }
                    }
                }
                cnt++;
            }
        }
        
        System.out.println(cnt);
        
    }
}
