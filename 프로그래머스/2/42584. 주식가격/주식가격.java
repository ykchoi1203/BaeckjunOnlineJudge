import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        
        for(int i=0; i<prices.length; i++) {
            while(!pq.isEmpty() && pq.peek()[1] > prices[i]) {
                int[] cur = pq.poll();
                answer[cur[0]] = i - cur[0];
            }
            pq.add(new int[] {i, prices[i]});
        }
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            answer[cur[0]] = prices.length - 1 - cur[0];
        }
        
        return answer;
    }
}