import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        for(int[] target : targets) {
            if(!pq.isEmpty() && target[0] >= pq.peek()[1]) {
                int time = pq.poll()[1];
                
                while(!pq.isEmpty() && pq.peek()[0] < time) {
                    pq.poll();
                }
                answer++;
            }
            
            pq.add(target);
        }
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            while(!pq.isEmpty() && cur[1] >= pq.peek()[0]) {
                pq.poll();
            }
            answer++;
        }
        
        return answer;
    }
}