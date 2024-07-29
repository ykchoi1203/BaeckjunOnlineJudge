import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] arr = new int[Math.max(n, m) * 2 + 2];
        
        Arrays.fill(arr, Integer.MAX_VALUE);
        
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[] {n, 0});
        
        while(!q.isEmpty() && q.peek()[0] != m) {
            int[] cur = q.poll();
            
            if(arr[cur[0]] > cur[1]) {
                arr[cur[0]] = cur[1];
                if(cur[0] - 1 >= 0)
                    q.add(new int[] {cur[0] - 1, cur[1] + 1});
                if(cur[0] + 1 < arr.length) {
                    q.add(new int[] {cur[0] + 1, cur[1] + 1});
                }
                if(cur[0] * 2 < arr.length) {
                    q.add(new int[] {cur[0] * 2, cur[1] + 1});
                }
            }
        }
        
        System.out.println(q.peek()[1]);
    }
}