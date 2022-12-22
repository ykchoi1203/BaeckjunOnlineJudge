class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        long pNum = Long.parseLong(p);
        for(int i=0; i<p.length()-1; i++) {
            sb.append(t.charAt(i));
        }
        for(int i=p.length()-1; i<t.length(); i++) {
            sb.append(t.charAt(i));
            if(Long.parseLong(sb.toString()) <= pNum) {
              answer++;  
            }
            sb.delete(0,1);
        }
        return answer;
    }
}