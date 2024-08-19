class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        
        if(s.length() == 1) return 1;
        else if(s.length() == 2 && s.charAt(0) == s.charAt(1)) return 2;
        else if(s.length() == 2) return 1;

        for(int i=0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            char start = s.charAt(i);
            sb.append(start);
            for(int j = i + 1; j < s.length(); j++) {
                char end = s.charAt(j);
                sb.append(end);
                if(start == end && j - i + 1 > answer && isTrue(s.substring(i, j + 1))) {
                    answer = j - i + 1;
                }
            }
        }

        return answer;
    }
    
    public boolean isTrue(String s) {
        int end = s.length() - 1;
        int start = 0;
        
        while(start < end) {
            if(s.charAt(end) != s.charAt(start)) {
                return false;
            }
            start++;
            end--;
        }
        
        return true;
    }
}