import java.util.TreeMap;
import java.util.Map;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        TreeMap<Character, Integer> alpa = new TreeMap<>();
        
        for(int i=0; i<s.length(); i++) {
            if(alpa.containsKey(s.charAt(i))) {
                alpa.put(s.charAt(i), alpa.get(s.charAt(i)) + 1);
            } else {
                alpa.put(s.charAt(i), 1);
            }
        }
        
        for(Map.Entry<Character, Integer> entry : alpa.entrySet()) {
			if(entry.getValue() == 1) {
                sb.append(entry.getKey());
            }
		}
        
        answer = sb.toString();
        return answer;
    }
}