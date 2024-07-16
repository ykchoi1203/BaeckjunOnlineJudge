import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[][] jobs) {
        int total = 0;
        int current = 0;
        int idx = 0;
        int cnt = 0;
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        while (cnt < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= current) {
                pq.add(jobs[idx++]);
            }

            if (pq.isEmpty()) {
                current = jobs[idx][0];
            } else {
                int[] cur = pq.poll();
                total += cur[1] + current - cur[0];
                current += cur[1];
                cnt++;
            }
        }
        return total / jobs.length;
    }
    

}