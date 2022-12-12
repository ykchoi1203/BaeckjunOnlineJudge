import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int min = score[0];
        answer[0] = score[0];
        List<Integer> al = new ArrayList<>();
        al.add(score[0]);
        for(int i=1; i<score.length; i++) {
            if(i < k) {
                if(min > score[i]) min = score[i];
                al.add(score[i]);
                answer[i] = min; 
            } else {
                if(min < score[i]) {
                    al.add(score[i]);
                    al = al.stream().sorted().collect(Collectors.toList());
                    al.remove(0);
                    min = al.get(0);
                    answer[i] = min;
                } else {
                    answer[i] = min;
                }
            }
        }
        return answer;
    }
}