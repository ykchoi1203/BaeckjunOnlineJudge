import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Map<String, Integer> map3 = new HashMap<>(); // 교
        Map<String, Integer> map4 = new HashMap<>(); // 합
        
        for(int i=0; i<str1.length()-1; i++) {
            char first = str1.charAt(i);
            char second = str1.charAt(i+1);
            
            if(second < 'a' || second > 'z') {
                i++;
                continue;
            }
            if(first < 'a' || first > 'z') {
                continue;
            }
            
            StringBuffer sb = new StringBuffer();
            sb.append(first);
            sb.append(second);
            String str = sb.toString();
            if(!map1.containsKey(str)) {
                map1.put(str, 0);
            }
            if(!map4.containsKey(str)) {
                map4.put(str, 0);
            }
            
            map1.put(str, map1.get(str) + 1);
            map4.put(str, map4.get(str) + 1);
        }
        
        for(int i=0; i<str2.length()-1; i++) {
            char first = str2.charAt(i);
            char second = str2.charAt(i+1);
            
            if(second < 'a' || second > 'z') {
                i++;
                continue;
            }
            if(first < 'a' || first > 'z') {
                continue;
            }
            
            StringBuffer sb = new StringBuffer();
            sb.append(first);
            sb.append(second);
            
            String str = sb.toString();
            
            if(!map2.containsKey(str)) {
                map2.put(str, 0);
            }
            
            map2.put(str, map2.get(str) + 1);
            
            if(map1.containsKey(str)) {
                if(!map3.containsKey(str)) {
                    map3.put(str, 0);
                }
                map3.put(str, Math.min(map1.get(str), map2.get(str)));
                map4.put(str, Math.max(map1.get(str), map2.get(str)));
            } else {
                map4.put(str, map2.get(str));
            }
            
            
            
        }
        
        if(map1.size() == 0 && map2.size() == 0) {
            return 65536;
        }
        
        int s1 = 0;
        int s2 = 0;
        
        for(String key : map3.keySet()) {
            s1 += map3.get(key);
        }
        
        for(String key : map4.keySet()) {
            s2 += map4.get(key);
        }
        
        
        double same = ((double)s1) / s2;
        
        answer = (int)Math.floor(same * 65536);
        
        return answer;
    }
}