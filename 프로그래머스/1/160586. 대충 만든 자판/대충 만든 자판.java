import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(String key : keymap) {
            for(int i=0; i<key.length(); i++) {
                char c = key.charAt(i);
                if(!map.containsKey(c)) {
                    map.put(c, i + 1);
                } else {
                    map.put(c, Math.min(i + 1, map.get(c)));
                }
            }
        }
        
        for(int i=0; i<answer.length; i++) {
            String target = targets[i];
            int sum = 0;
            for(int j=0; j<target.length(); j++) {
                char c = target.charAt(j);
                if(!map.containsKey(c)) {
                    sum = -1;
                    break;
                }
                sum += map.get(c);
            }
            answer[i] = sum;
        }
        
        return answer;
    }
}