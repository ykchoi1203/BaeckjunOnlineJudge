import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        
        for(int i=0; i<8; i++) {
            pq.add(new int[] {i + 1, sc.nextInt()});
        }
        
        PriorityQueue<Integer> num = new PriorityQueue<>();
        
        int sum = 0;
        
        for(int i=0; i<5; i++) {
            int[] cur = pq.poll();
            
            sum += cur[1];
            num.add(cur[0]);
        }
        
        System.out.println(sum);
        
        for(int i=0; i<5; i++) {
            System.out.print(num.poll() + " ");
        }
    }
}