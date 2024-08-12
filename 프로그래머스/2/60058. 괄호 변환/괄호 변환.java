class Solution {
    public String solution(String p) {
        String answer = "";
        
        if(p.length() == 0) return answer;
        
        answer = dfs(p);
        
        return answer;
    }
    
    public String dfs(String p) {
        if(p.length() == 0) return "";
        int sum = p.charAt(0) == '(' ? 1 : -1;
        String u = "";
        String v = "";
        
        for(int i=1; i<p.length(); i++) {
            sum += p.charAt(i) == '(' ? 1 : -1;
            if(sum == 0) {
                u = p.substring(0, i + 1);
                v = p.substring(i + 1, p.length());
                break;
            }
        }
        
        
        if(isCorrect(u)) {
            return u + dfs(v);
        }
        
        u = u.substring(1, u.length()-1);
        
        char[] uChar = u.toCharArray();
        
        for(int i=0; i<uChar.length; i++) {
            if(uChar[i] == '(') {
                uChar[i] = ')';
            } else {
                uChar[i] = '(';
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(dfs(v)).append(")").append(new String(uChar));
        
        return sb.toString();
        
    }
    
    public boolean isCorrect(String p) {
        int sum = 0;
        
        for(int i=0; i<p.length(); i++) {
            sum += p.charAt(i) == '(' ? 1 : -1;
            if(sum < 0) return false;
        }
        
        if(sum != 0) return false;
        return true;
    }
}