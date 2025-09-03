import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=1; i<=n; i++) {
            q.offer(i);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!q.isEmpty()) {
            sb.append(q.poll()).append(" ");
            
            if(q.size() > 0) {
                q.offer(q.poll());
            }
        }
        
        System.out.print(sb);
    }
}