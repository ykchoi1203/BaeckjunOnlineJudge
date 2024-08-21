class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for(int i = 1; i < r2; i++) {
            long r2Y = (long)Math.sqrt(r2 * (long)r2 - i * (long)i);
            double r1Y = Math.sqrt(r1 * (long)r1 - i * (long)i);
            answer += r2Y - (long)r1Y;
            if(r1Y == Math.floor(r1Y)) {
                answer++;
            }
        }
        
        answer = answer * 4 + (r2 - r1) * 4;
        
        return answer;
    }
}