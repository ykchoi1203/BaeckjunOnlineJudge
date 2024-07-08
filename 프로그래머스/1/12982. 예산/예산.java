import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        while(answer < d.length && budget >= d[answer]) {
            budget -= d[answer];
            answer++;
        }
        return answer;
    }
}