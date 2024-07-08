import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[] {0, 0};
        int personIdx = 1;
        int round = 1;
        Set<String> set = new HashSet<>();
        
        for(int i=0; i<words.length; i++) {
            if(set.contains(words[i])) {
                return new int[] {personIdx, round};
            } else if(i != 0 && words[i-1].charAt(words[i-1].length() -1) != words[i].charAt(0)) {
                return new int[] {personIdx, round};
            }
            set.add(words[i]);
            personIdx++;
            if(personIdx > n) {
                personIdx = 1;
                round++;
            }
        }

        return answer;
    }
}