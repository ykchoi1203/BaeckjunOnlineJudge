import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<n; i++) {
            int k = sc.nextInt();
            
            if(k == 0) {
                if(pq.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                pq.offer(k);
            }
        }
        
        System.out.println(sb.toString());
            
    }
}