import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize == 0) {
            return cities.length * 5;
        }
        
        Queue<String> queue = new LinkedList<>();
        
        for(int i=0; i<cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
            if(!queue.contains(cities[i])) {
                answer += 5;
                if(queue.size() == cacheSize) {
                    queue.poll();
                }
                queue.add(cities[i]);
            } else {
                answer += 1;
                queue.remove(cities[i]);
                queue.add(cities[i]);
            }
        }
        
        return answer;
    }
}