import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        if(s.length() % 2 == 1) return 0;
        
        for(int i=0; i<s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(i,s.length())).append(s.substring(0, i));
            if(isTrue(sb.toString())) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isTrue(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(stack.isEmpty() && (c == '}' || c == ']' || c == ')')) {
                return false;
            } else if(c == '(' || c == '{' || c == '[') {
                stack.add(c);
            } else {
                char c2 = stack.pop();
                if(c == ')') {
                    if(c2!= '(') return false;
                } else if(c == '}' && c2 != '{') return false;
                else if(c == ']' && c2 != '[') return false;
            }
        }
        
        if(stack.size() != 0) return false;
        return true;
    }
               
}