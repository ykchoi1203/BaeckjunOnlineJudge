import java.util.*;
class Solution {
    boolean solution(String s) {
//         boolean answer = true;
        
//         if(s.length() % 2 != 0)
//             return false;
       
        
//         int cnt = 0;
//         int cnt1 = 0;
        
//         for(int i=0; i<s.length()/2; i++){
//             if(s.charAt(i) == '(')
//                 cnt++;
//             else
//                 cnt--;
//             if(cnt < 0)
//                 return false;
            
//             if(s.charAt(s.length() - 1 -i) == '(')
//                 cnt1++;
//             else
//                 cnt1--;
//             if(cnt1 > 0)
//                 return false;
            
//         }
//         return cnt + cnt1 == 0 ? true : false;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(0);
            } else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty() ? true : false;
        
    }
    
}