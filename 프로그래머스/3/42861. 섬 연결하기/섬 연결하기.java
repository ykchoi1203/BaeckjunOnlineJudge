import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        int[][] costMap = new int[n][n];

        for(int[] cost : costs) {
            costMap[cost[0]][cost[1]] = cost[2];
            costMap[cost[1]][cost[0]] = cost[2];
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        
        for(int i = 1; i<n; i++) {
            if(costMap[0][i] != 0)
                pq.add(new int[] {0, i, costMap[0][i]});
        }
        
        visited[0] = true;
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();

            if(!visited[cur[1]]) {
                visited[cur[1]] = true;
                for(int i=0; i<n; i++) {
                    if(!visited[i] && costMap[cur[1]][i] != 0) {
                        pq.add(new int[] {cur[1], i, costMap[cur[1]][i]});
                    }
                }
                answer += costMap[cur[0]][cur[1]];
            }
        }

        return answer;
    }
}