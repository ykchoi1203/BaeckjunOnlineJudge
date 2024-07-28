class Solution {
    public long solution(long n) {
        long answer = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        
        String number = sb.toString();
        
        int[] cnt = new int[10];
        
        for(int i=0; i<number.length(); i++) {
            cnt[number.charAt(i) - '0']++;
        }
        
        sb = new StringBuilder();
        for(int i=9; i>=0; i--) {
            while(cnt[i] > 0) {
                cnt[i]--;
                sb.append(i);
            }
        }
        
        return Long.parseLong(sb.toString());
    }
}