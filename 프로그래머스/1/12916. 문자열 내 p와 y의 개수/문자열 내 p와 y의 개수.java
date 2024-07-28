class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int[] cnt = new int[2];
        
        for(char c : s.toCharArray()) {
            if(c == 'p' || c == 'P') {
                cnt[0]++;
            } else if(c == 'y' || c == 'Y') {
                cnt[1]++;
            }
        }
        
        return cnt[0] == cnt[1];
    }
}