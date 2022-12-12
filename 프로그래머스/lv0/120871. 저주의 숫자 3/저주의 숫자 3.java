class Solution {
    public int solution(int n) {
        int answer = 0;
		for(int i=1; i<=n; i++) {
			// answer++;
			// while((answer/10 == 3) || (answer%3==0) || (answer % 10 == 3) || (answer > 100 && answer/10 % 10 == 3)) {
			// 	answer++;
			// }
            answer++;
            while(answer % 3 == 0 || String.valueOf(answer).contains("3")) {
                answer++;
            }
		}
		return answer;
    }
}