class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        
        while(l <= r) {
            if(isTrue(l-1)) {
                answer++;
            }
            l++;
        }
        
        return answer;
    }
    
    public boolean isTrue(long l) {
        while(l >= 1) {
            if(l % 5 == 2) {
                return false;
            }
            l /= 5;
        }
        
        return true;
    }
     
}