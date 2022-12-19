class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i=0; i<s.length(); i++) {
            char x = s.charAt(i);
            int xCnt = 1;
            int otherCnt = 0;
            int k = 0;
            for(int j=i+1; j<s.length(); j++) {
                k++;
                if(x == s.charAt(j)) xCnt++;
                else otherCnt++;
                
                if(xCnt == otherCnt) {
                    break;
                }
            }
            answer++;
            i += k;
        }
        return answer;
    }
}