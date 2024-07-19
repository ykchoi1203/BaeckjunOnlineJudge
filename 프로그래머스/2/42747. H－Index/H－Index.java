import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        if(citations[0] > citations.length) {
            return citations.length;
        }
    
        for(int i=citations.length-1; i>= 0; i--) {
            if(citations[i] >= citations.length - i) {
                answer = Math.max(answer, citations.length - i);
            } else {
                answer = Math.max(answer, citations[i]);
            }
         }
        
        return answer;
    }
}