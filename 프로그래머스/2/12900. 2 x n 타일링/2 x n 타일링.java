class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if(n == 1) return 1;
        
        int x = 1;
        int nextX = 1;
        
        int start = 1;
        
        while(start <= n) {
            int k = nextX;
            nextX = (nextX + x) % 1000000007;
            x = k;
            start++;
        }
        
        answer = x % 1000000007;
        
        return answer;
    }
}