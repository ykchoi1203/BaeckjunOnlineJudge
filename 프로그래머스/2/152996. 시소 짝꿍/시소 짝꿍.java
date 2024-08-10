import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> original = new HashMap<>();
        
        for(int weight : weights) {
            int count = 0;
            if(!original.containsKey(weight)) {
                original.put(weight, 0);
            } 
            
            original.put(weight, original.get(weight) + 1);
            
            if(!map.containsKey(weight * 4)) {
                map.put(weight * 4, 0);
            }
            if(!map.containsKey(weight * 3)) {
                map.put(weight * 3, 0);
            }
            if(!map.containsKey(weight * 2)) {
                map.put(weight * 2, 0);
            }
            
            map.put(weight * 2, map.get(weight * 2) + 1);
            map.put(weight * 3, map.get(weight * 3) + 1);
            map.put(weight * 4, map.get(weight * 4) + 1);
            
        }
        
        for(int weight : weights) {
            int count = original.get(weight) - 1;
            
            answer += count;
            
            answer += map.get(weight * 2) - count - 1;
            answer += map.get(weight * 3) - count - 1;
            answer += map.get(weight * 4) - count - 1;
            
        }
        
        return answer / 2;
    }
}