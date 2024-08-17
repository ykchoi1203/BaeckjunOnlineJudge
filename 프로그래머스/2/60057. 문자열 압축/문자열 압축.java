class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i = 1; i <= s.length() / 2; i++) {
            int idx = 0;
            int cnt = 0;
            String copyS = new String(s);
            StringBuilder sb = new StringBuilder();
            
            while(idx < s.length()) {
                if(idx + i >= s.length()) {
                    cnt += s.length() - idx;
                    break;
                }
                if(sb.length() != 0)
                    copyS = copyS.substring(sb.length() - i);
                sb = new StringBuilder();
                String checkString = s.substring(idx, idx + i);
                
                int lastIdx = idx;
                int sum = 0;
                while(copyS.startsWith(sb.toString())) {
                    sb.append(checkString);
                    lastIdx += i;
                    sum++;
                }
                lastIdx -= i;
                sum--;
                cnt += lastIdx == idx + i ? i : Integer.toString(sum).toString().length() + i;
                idx = lastIdx;
            }
            answer = Math.min(answer, cnt);
        }
        
        return answer;
    }
}