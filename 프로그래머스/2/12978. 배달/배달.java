import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        int[] cost = new int[N];
        int[][] roads = new int[N][N];
        
        for(int i = 0; i < roads.length; i++) {
            Arrays.fill(roads[i], Integer.MAX_VALUE);
        }
        
        for(int[] curRoad : road) {
            int a = curRoad[0] - 1;
            int b = curRoad[1] - 1;
            int roadCost = curRoad[2];
            roads[a][b] = Math.min(roads[a][b], roadCost);
            roads[b][a] = Math.min(roads[b][a], roadCost);
        }
        
        Arrays.fill(cost, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        pq.add(new int[] {0, 0});
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            if(cost[cur[0]] > cur[1]) {
                cost[cur[0]] = cur[1];
                
                for(int i = 0; i < N; i++) {
                    if(i != cur[0] && roads[cur[0]][i] != Integer.MAX_VALUE && cost[i] > cur[1] + roads[cur[0]][i]) {
                        pq.add(new int[] {i, cur[1] + roads[cur[0]][i]});
                    }
                }
            }            
        }
        
        answer = (int)Arrays.stream(cost).filter(i -> i <= K).count();

        return answer;
    }
}