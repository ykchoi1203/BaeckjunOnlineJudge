import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        boolean[] visited = new boolean[n + 1];
        visited[n] = true;
        
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(n);
        
        queue.add(list);
        
        while(!queue.isEmpty()) {
            ArrayList<Integer> cur = queue.poll();
            
            if(cur.get(cur.size() - 1) == 1) {
                System.out.println(cur.size() - 1);
                for(int i=0; i<cur.size(); i++) {
                    System.out.print(cur.get(i) + " ");
                }
                return;
            }
            
            int size = cur.size();
            
            if(cur.get(size-1) % 3 == 0 && !visited[cur.get(size-1) / 3]) {
                ArrayList<Integer> newList = new ArrayList<>(cur);
                newList.add(cur.get(size-1) / 3);
                queue.add(newList);
                visited[cur.get(size-1) / 3] = true;
            }

            if(cur.get(size-1) % 2 == 0 && !visited[cur.get(size-1) / 2]) {
                ArrayList<Integer> newList = new ArrayList<>(cur);
                newList.add(cur.get(size-1) / 2);
                queue.add(newList);
                visited[cur.get(size-1) / 2] = true;
            }
            
            if(!visited[cur.get(size-1) - 1]) {
                ArrayList<Integer> newList = new ArrayList<>(cur);
                newList.add(cur.get(size-1) - 1);
                queue.add(newList);
                visited[cur.get(size-1) - 1] = true;
            }
        }
    }
}