class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end - begin) + 1];
        
        for(long i=0; i<answer.length; i++) {
            answer[(int)i] = getNum(i + begin);
        }
        
        return answer;
    }
    
    public int getNum(long n) {
        if(n == 1) return 0;
        int number = 1;
        for(int i=2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) { 
                if(n / i <= 10000000)
                    return (int)(n / i);
                else number = i;
                    
            };
        }
        
        return number;
    }
}