import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<long[]> queue = new LinkedList<>();
        
        queue.add(new long[] {(long)n, 1});
        
        while(!queue.isEmpty()) {
            long[] cur = queue.poll();
            
            if(cur[0] == (long)k) {
                System.out.println(cur[1]);
                return;
            }
            
            if(cur[0] * 10 + 1 <= (long)k) {
                queue.add(new long[] {cur[0] * 10 + 1, cur[1] + 1});
            }
            
            if(cur[0] * 2 <= (long)k) {
                queue.add(new long[] {cur[0] * 2, cur[1] + 1});
            }
        }
        
        System.out.println(-1);
        
    }
}