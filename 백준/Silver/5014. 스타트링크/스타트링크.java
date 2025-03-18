import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int f = sc.nextInt();
        int s = sc.nextInt();
        int g = sc.nextInt();
        int u = sc.nextInt();
        int d = sc.nextInt();
        
        if(s == g) {
            System.out.println(0);
            return;
        }
        
        int[] visited = new int[f + 1];
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(s);
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            if(u != 0 && cur + u <= f && cur + u != s && visited[cur + u] == 0) {
                visited[cur + u] = visited[cur] + 1;
                q.add(cur + u);
            }
            
            if(d != 0 && cur - d >= 1 && cur - d != s && visited[cur - d] == 0) {
                visited[cur - d] = visited[cur] + 1;
                q.add(cur - d);
            }
        }
        
        System.out.println(visited[g] == 0 ? "use the stairs" : visited[g]);
        
    }
}