import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<n; i++) {
            pq.offer(sc.nextInt());
        }
        
        while(pq.size() > 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            
            answer += num1 + num2;
            pq.offer(num1 + num2);
        }
        
        System.out.println(answer);
        
    }
}