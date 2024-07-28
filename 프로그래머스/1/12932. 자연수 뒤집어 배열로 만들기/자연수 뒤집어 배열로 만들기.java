class Solution {
    public int[] solution(long n) {
        int[] answer = new int[(int)Math.log10(n) + 1];
        int idx = 0;
        int lastNum = 0;
        
        if(answer.length > 9) {
            lastNum = (int) (n / 1000000000L);
        }
        
        if(lastNum != 0) {
            n -= (long)lastNum * 1000000000L;
        }
        
        while(idx < answer.length && n > 0) {
            answer[idx++] = ((int)n % 10);
            n /= 10;
        }
        
        while(idx < answer.length) {
            answer[idx++] = lastNum % 10;
            lastNum /= 10;
        }
        
        return answer;
    }
}