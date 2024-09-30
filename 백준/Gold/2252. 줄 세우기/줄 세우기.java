import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] arr = new int[n+1];
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        for(int i=1; i<=n; i++) {
            map.put(i, new HashSet<>());
        }
        
        
        while(m > 0) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            
            if(map.get(start).add(end)) 
                arr[end]++;
            m--;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=1; i<=n; i++) {
            if(arr[i] == 0)
                queue.add(i);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            list.add(cur);
            
            for(int next : map.get(cur)) {
                arr[next]--;
                if(arr[next] == 0) {
                    queue.add(next);
                }
            }
        }

        for(int number : list) {
            System.out.print(number + " ");
        }
        
    }
}