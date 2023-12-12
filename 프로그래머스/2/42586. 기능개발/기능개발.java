import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        ArrayList<Integer> al = new ArrayList<>();
        int idx = 0;
        while(idx < progresses.length) {
            for(int i=idx; i<progresses.length; i++) {
                progresses[i] += speeds[i];
            }
            if(progresses[idx]>=100) {
                int cnt=0;
                while(idx < progresses.length && progresses[idx] >= 100) {
                    idx++;
                    cnt++;
                }
                al.add(cnt);
            }
        }
        answer = new int[al.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = al.get(i);
        }
        return answer;
    }
}