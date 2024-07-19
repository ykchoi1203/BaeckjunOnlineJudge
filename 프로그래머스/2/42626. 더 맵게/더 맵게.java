import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int sum = 0;
        
        for(int food : scoville) {
            sum += food;
            pq.add(food);
        }
        
        int amount = scoville.length;
        
        while(!pq.isEmpty() && amount > 0 && pq.peek() < K) {
            if(pq.size() < 2) {
                return -1;
            }
            
            int firstFood = pq.poll();
            int secondFood = pq.poll();
            
            int newFood = firstFood + 2 * secondFood;
            pq.add(newFood);
            sum += secondFood;
            amount--;
            answer++;
            
        }
        
        if(amount == 0) return -1;
        else if(amount == 1 && sum < K) return -1;
        else if(amount == 1 && sum >= K) return answer;
        
        return answer;
    }
}