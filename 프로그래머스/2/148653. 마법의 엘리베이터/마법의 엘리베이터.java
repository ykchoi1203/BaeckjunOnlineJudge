class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0) {
            int remain = storey % 10;
            storey = storey / 10;
            
            if(remain > 5) {
                storey++;
                remain = 10 - remain;
            } else if(remain == 5 && storey % 10 >= 5) {
                storey++;
                remain = 10 - remain;
            }
            
            answer += remain;
            
        }
        
        return answer;
    }
}