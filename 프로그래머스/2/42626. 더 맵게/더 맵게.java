import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int food : scoville) {
            pq.add(food);
        }
        
        while(!pq.isEmpty() && pq.peek() < K) {
            if(pq.size() < 2) {
                return -1;
            }
            
            int firstFood = pq.poll();
            int secondFood = pq.poll();
            
            int newFood = firstFood + 2 * secondFood;
            pq.add(newFood);

            answer++;
        }
        
        if(pq.size() == 0) return -1;
        else if(pq.size() == 1 && pq.peek() < K) return -1;
        else if(pq.size() == 1 && pq.peek() >= K) return answer;
        
        return answer;
    }
}
