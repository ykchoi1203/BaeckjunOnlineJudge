import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int[] road : roads) {
            if(!map.containsKey(road[0])) {
                map.put(road[0], new ArrayList<>());
            }
            if(!map.containsKey(road[1])) {
                map.put(road[1], new ArrayList<>());
            }
            map.get(road[0]).add(road[1]);
            map.get(road[1]).add(road[0]);
        }
        int idx = 0;
        for(int source : sources) {
            if(source == destination) {
                answer[idx++] = 0;
                continue;
            }
            
            boolean[] visited = new boolean[n+1];
            visited[source] = true;
            
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] {source, 0});
            
            while(!queue.isEmpty() && answer[idx] == 0) {
                int[] cur = queue.poll();
                
                if(map.containsKey(cur[0])) {
                    for(int i : map.get(cur[0])) {
                        if(!visited[i]) {
                            visited[i] = true;
                            queue.add(new int[] {i, cur[1] + 1});
                            if(i == destination) {
                                answer[idx] = cur[1] + 1;
                                break;
                            }
                        }
                    }
                }
            }
            
            if(answer[idx] == 0) {
                answer[idx] = -1;
            }
            
            idx++;
        }        
        return answer;
    }
}