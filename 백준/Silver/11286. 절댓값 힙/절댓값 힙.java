import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if(Math.abs(a) != Math.abs(b)) {
                return Math.abs(a) - Math.abs(b);
            }
            
            return a - b;
        });
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<n; i++) {
            int cur = sc.nextInt();
            
            if(cur == 0) {
                if(!pq.isEmpty()) {
                    sb.append(pq.poll()).append("\n");
                } else {
                    sb.append("0\n");
                }
            } else {
                pq.add(cur);
            }
        }
        
        System.out.println(sb.toString());
        
    }
}