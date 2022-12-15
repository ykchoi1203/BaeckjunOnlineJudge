class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int k;
        for(int i=1; i<=number; i++) {
            k = count(i);
            if(k > limit) k = power;
            answer += k;
        }
        return answer;
    }
    
    public int count(int num) {
        int cnt = 0;
        for(int i=1; i<=Math.sqrt(num); i++) {
            if(Math.sqrt(num) == i) cnt++;
            else if(num % i == 0) {
                cnt += 2;
            }
        }
        return cnt;
    }
}