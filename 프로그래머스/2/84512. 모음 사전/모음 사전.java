import java.util.*;
class Solution {
    public int solution(String word) {
        dfs("", word);
        
        return answer;
    }
    
    static ArrayList<String> list = new ArrayList<>();
    int answer = 0;
    String[] alpha = new String[] {"A", "E", "I", "O", "U"};
    
    public void dfs(String cur, String word) {
        if(cur.length() == 5) {                
            return;
        }
    
        
        for(int i=0; i<alpha.length; i++) {
            String addString = cur + alpha[i];
            list.add(addString);
            if(addString.equals(word)) {
                answer = list.size();
                return;
            }
            
            dfs(addString, word);
            
            if(answer != 0) return;
        }
    }
}