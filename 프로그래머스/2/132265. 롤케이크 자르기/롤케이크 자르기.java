import java.util.*;
import java.util.stream.Collectors.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        int[] left = new int[topping.length];
        int[] right = new int[topping.length];
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        for(int i=0; i<topping.length; i++) {
            set1.add(topping[i]);
            left[i] = set1.size();
            set2.add(topping[topping.length-i-1]);
            right[topping.length-i-1] = set2.size();
        }
        
        for(int i=1; i<topping.length-1; i++) {
            if(left[i-1] == right[i]) {
                answer++;
            }
        }
        
        return answer;
    }
}