import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        ArrayList<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<26; i++) {
            String str = (char)('A' + i) + "";
            map.put(str, i+1);
        }
        
        for(int i=0; i<msg.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(msg.charAt(i));
            
            while(i + 1 < msg.length() && map.containsKey(sb.toString() + msg.charAt(i+1))) {
                i++;
                sb.append(msg.charAt(i));
            }
            list.add(map.get(sb.toString()));
            if(i + 1 < msg.length()) {
                sb.append(msg.charAt(i + 1));
            }
            if(!map.containsKey(sb.toString())) {
                map.put(sb.toString(), map.size() + 1);
            }
        }
        
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}