class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        boolean[] isTrue = new boolean[10];
        
        for(int number : numbers) {
            isTrue[number] = true;
        }
        
        for(int i=0; i<10; i++) {
            answer += isTrue[i] ? 0 : i;
        }
        
        return answer;
    }
}