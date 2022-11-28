import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        // Arrays.sort(participant);
        // Arrays.sort(completion);
        // for(int i=0; i<completion.length; i++) {
        //     if(!completion[i].equals(participant[i])) return participant[i];
        // }
        HashMap<String, Integer> map = new HashMap<>();
        for(String name : participant) map.put(name, map.getOrDefault(name, 0) + 1);
        for(String name : completion) map.put(name, map.get(name) -1);

        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        for(Map.Entry<String, Integer> el : entry){
            if(el.getValue() != 0) return el.getKey();
        }
        return participant[participant.length-1];
    }
}