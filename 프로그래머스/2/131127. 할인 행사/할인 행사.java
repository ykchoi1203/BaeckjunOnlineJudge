import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        int j=0;
        int sum = Arrays.stream(number).sum();
        for(String fruit : want) {
            map.put(fruit, j++);
        }
        
        for(int i=0; i<10 && i < discount.length; i++) {
            if(map.containsKey(discount[i]))
                number[map.get(discount[i])]--;
        }
        
        for(int i=0; i<discount.length; i++) {
            boolean count = true;
            for(int k=0; k < number.length; k++) {
                if(number[k] > 0) {
                    count = false;
                    break;
                }
            }
            
            if(count) {
                answer++;
            }
            
            if(map.containsKey(discount[i]))
                number[map.get(discount[i])]++;
            if(i + 10 < discount.length && map.containsKey(discount[i+10])) {
                number[map.get(discount[i+10])]--;
            }
        }
        
        return answer;
    }
}