import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        
        for(int[] vertex : edge) {
            map.get(vertex[0]).add(vertex[1]);
            map.get(vertex[1]).add(vertex[0]);
        }
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(Integer i : map.get(1)) {
            queue.add(new int[] {i, 1});
        }
        
        int max = 0;
        int cnt = 0;
                
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            if(!visited[cur[0]]) {
                if(max < cur[1]) {
                    max = cur[1];
                    cnt = 1;
                } else if(max == cur[1]) {
                    cnt++;
                }
                
                visited[cur[0]] = true;
                
                for(int i : map.get(cur[0])) {
                    if(!visited[i]) {
                        queue.add(new int[] {i, cur[1] + 1});
                    }
                }
            }
        }   
        
        return cnt;
    }
}