import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        ArrayList<Long> list = new ArrayList<>();
        long K = (long)k;
        list.add(K);
        while(K > 1) {
            if(K % 2 == 0) {
                K /= 2;
            } else {
                K = 3 * K + 1;
            }
            list.add(K);
        }
        
        long[] dp = new long[list.size()];
        
        for(int i=1; i < dp.length; i++) {
            dp[i] = i > 1 ? (list.get(i) + list.get(i-1)) + dp[i-1] : (list.get(i) + list.get(i-1));
        }
        
        for(int i=0; i<ranges.length; i++) {
            if(Math.min(ranges[i][0], dp.length - 1 + ranges[i][1]) >= dp.length || ranges[i][0] > dp.length - 1 + ranges[i][1]) {
                answer[i] = -1;
            } else {
                answer[i] = (dp[Math.max(ranges[i][0], dp.length - 1 + ranges[i][1])] - dp[Math.min(ranges[i][0], dp.length - 1 + ranges[i][1])]) * 0.5;
            }
        }
        
        return answer;
    }
}