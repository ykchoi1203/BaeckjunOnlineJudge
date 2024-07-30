class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        int start = 0;
        int idx = p - 1;

        StringBuilder sb = new StringBuilder();
        
        while(sb.length() < t * m) {
            String change = Integer.toString(start, n).toUpperCase();
            
            for(int i = 0; i < change.length(); i++) {
                sb.append(change.charAt(i));
            }
            start++;
        }
        
        StringBuilder sb2 = new StringBuilder();
        while(sb2.length() < t) {
            sb2.append(sb.charAt(idx));
            idx += m;
        }
        
        return sb2.toString();
    }
}