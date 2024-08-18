class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for(int i=0; i <= d; i += k) {
            answer = answer + (long)Math.floor(round(d, i) / k) + 1;
        }
        
        return answer;
    }
    
    public double round(long d, long x) {
        return Math.sqrt(d * d - x * x);
    }
}