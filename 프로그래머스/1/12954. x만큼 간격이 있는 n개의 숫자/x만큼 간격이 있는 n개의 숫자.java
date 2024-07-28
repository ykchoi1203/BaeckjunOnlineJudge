class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        int idx = 1;
        answer[0] = (long) x;
        
        while(idx < answer.length) {
            answer[idx] = answer[idx - 1] + x;
            idx++;
        }
        
        return answer;
    }
}