import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        Deque<Integer> queue = new ArrayDeque<>();
        
        for(int i=1; i<=n; i++) {
            queue.addLast(i);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(queue.size() > 1) {
            for(int i=0; i<m-1; i++) {
                queue.addLast(queue.pollFirst());
            }
            sb.append(queue.pollFirst()).append(", ");
        }
        
        sb.append(queue.pollFirst()).append(">");
        
        System.out.println(sb.toString());
    }
}