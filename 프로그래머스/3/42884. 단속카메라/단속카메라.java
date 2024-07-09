import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        int last = routes[0][1];
        
        for(int[] route : routes) {
            if(last < route[0]) {
                last = route[1];
                answer++;
            }
        }
            
        
        return answer;
    }
}