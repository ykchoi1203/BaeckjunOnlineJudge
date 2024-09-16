import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<n; i++) {
            int number = sc.nextInt();
            
            if(number == 0) {
                sb.append(queue.isEmpty() ? 0 : queue.poll()).append("\n");
            } else {
                queue.add(number);
            }
        }
        
        System.out.println(sb.toString());
    }
}