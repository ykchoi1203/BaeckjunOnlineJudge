class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        if(str1.length() != str1.replaceAll(str2, "").length()) {
			answer = 1;
		} else {
			answer = 2;
		}
        return answer;
    }
}