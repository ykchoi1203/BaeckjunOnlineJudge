import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        
        int aScore = scores[0][0];
        int bScore = scores[0][1];
        
        Arrays.sort(scores, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] + o1[1] > o2[0] + o2[1]) {
                    return -1;
                } else if(o1[0] + o1[1] == o2[0] + o2[1]) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        
        if(aScore == scores[0][0] && bScore == scores[0][1]) {
            return 1;
        }
        
        int sum = scores[0][0] + scores[0][1];
        int count = 1;
        for(int i=1; i<scores.length; i++) {
            boolean isTrue = true;
            for(int j = 0; j < i; j++) {
                if(scores[i][0] < scores[j][0] && scores[i][1] < scores[j][1]) {
                    isTrue = false;
                    break;
                } else if(scores[i][0] + scores[i][1] == scores[j][0] + scores[j][1]) {
                    break;
                }
            }
            
            if(isTrue) {
                if(sum == scores[i][0] + scores[i][1]) {
                    count++;
                } else {
                    sum = scores[i][0] + scores[i][1];
                    answer += count;
                    count = 1;
                }
            }
            
            if(scores[i][0] == aScore && scores[i][1] == bScore) {
                return isTrue ? answer : -1;
            }
        }
        
        return answer;
    }
    
}