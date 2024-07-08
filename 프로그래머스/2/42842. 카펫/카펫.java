class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int i=1;
        
        while(yellow / i >= Math.sqrt(yellow)) {
            if(yellow % i == 0) {
                int y = i;
                int x = yellow / i;
                
                if(brown == 2 * (y + x) + 4) {
                    return new int[] {x + 2, y + 2};
                }
                i++;
            } else {
                i++;
            }
        }
        
        return answer;
    }
}