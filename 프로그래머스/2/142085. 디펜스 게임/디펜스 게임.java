import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        if(k >= enemy.length) return enemy.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        for(int i=0; i<enemy.length; i++) {
            pq.add(enemy[i]);
            n -= enemy[i];
            
            while(n < 0 && !pq.isEmpty() && k > 0) {
                n += pq.poll();
                k--;
            }
            
            if(n < 0) return i;
        }
        
        return enemy.length;
    }
}