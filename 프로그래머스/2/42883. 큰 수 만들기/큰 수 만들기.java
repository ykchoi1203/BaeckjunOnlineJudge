import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int remain = number.length() - k - 1;

        for(int i=0; i<number.length() - k; i++) {
            char c = number.charAt(idx);
            int maxIdx = idx;

            if(c != '9') {
                for(int j=idx + 1; j < number.length() - remain; j++) {
                    if(c < number.charAt(j)) {
                        c = number.charAt(j);
                        maxIdx = j;
                        if(c == '9') break;
                    }
                }
            }

            sb.append(c);

            remain --;
            idx = maxIdx + 1;

        }

        return sb.toString();
    }
    
    
}