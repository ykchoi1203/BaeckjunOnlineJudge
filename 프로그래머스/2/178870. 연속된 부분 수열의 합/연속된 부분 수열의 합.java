class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, sequence.length-1};
        int start = 0;
        int sum = 0;
        for(int i=0; i<sequence.length; i++) {
            sum += sequence[i];
            if(sum == k) {
                if(answer[1] - answer[0] > i - start) {
                    answer[0] = start;
                    answer[1] = i;
                }
                sum -= sequence[start];
                start++;
            } else if(sum > k) {
                while(sum > k) {
                    sum -= sequence[start];
                    start++;
                }
                if(sum == k) {
                    if(answer[1] - answer[0] > i - start) {
                        answer[0] = start;
                        answer[1] = i;
                    }
                    sum -= sequence[start];
                    start++;
                }
            }
            
        }
        
        return answer;
    }
}