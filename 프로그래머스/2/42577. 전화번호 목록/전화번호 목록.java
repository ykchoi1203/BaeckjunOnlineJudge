import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> set = new HashSet<>();
        if(phone_book.length == 1) return true;
        
        Arrays.sort(phone_book);

        for(String phone : phone_book) {
            if(set.isEmpty()) {
                set.add(phone);
                continue;
            }
            StringBuffer sb = new StringBuffer();
            int idx = 0;
            while(idx < phone.length()) {
                sb.append(phone.charAt(idx));
                if(set.contains(sb.toString())) {
                    return false;
                }
                idx++;
            }
            set.add(phone);
        }
        
        
        return answer;
    }
}