import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<skill.length(); i++) {
            map.put(skill.charAt(i), i);
        }
        
        for(String skillTree : skill_trees) {
            boolean[] learn = new boolean[map.size()];
            boolean canLearn = true;
            loop:
            for(int i=0; i<skillTree.length(); i++) {
                char c = skillTree.charAt(i);
                
                if(map.containsKey(c)) {
                    for(int j= map.get(c)-1; j >=0; j--) {
                        if(!learn[j]) {
                            canLearn = false;
                            break loop;
                        }
                    }
                    learn[map.get(c)] = true;
                }
            }
            if(canLearn) {
                answer++;
            }
        }
        
        return answer;
    }
}