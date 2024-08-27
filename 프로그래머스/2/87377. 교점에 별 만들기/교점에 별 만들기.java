import java.util.*;
class Solution {
    public String[] solution(int[][] line) {
        String[] answer = {};
        Set<long[]> stars = new HashSet<>();
        long startX = Long.MAX_VALUE;
        long startY = Long.MAX_VALUE;
        long endX = Long.MIN_VALUE;
        long endY = Long.MIN_VALUE;
        
        for(int i=0; i<line.length-1; i++) {
            List<long[]> list = new ArrayList<>();
            for(int j=i+1; j<line.length; j++) {
                if((long)line[i][0] * line[j][1] - (long)line[i][1] * line[j][0] != 0) {
                    if(((long)line[i][1] * line[j][2] - (long)line[i][2] * line[j][1]) % ((long)line[i][0] * line[j][1] - (long)line[i][1] * line[j][0]) == 0 && ((long)line[i][2] * line[j][0] - (long)line[i][0] * line[j][2]) % ((long)line[i][0] * line[j][1] - (long)line[i][1] * line[j][0]) == 0) {
                    long x = (int)(((long)line[i][1] * line[j][2] - (long)line[i][2] * line[j][1]) / ((long)line[i][0] * line[j][1] - (long)line[i][1] * line[j][0]));
                    long y = (int)(((long)line[i][2] * line[j][0] - (long)line[i][0] * line[j][2]) / ((long)line[i][0] * line[j][1] - (long)line[i][1] * line[j][0]));
                        list.add(new long[] {x, y});
                        stars.add(new long[] {x, y});
                    }
                }
            }
            
            list.sort((a, b) -> Long.compare(a[0], b[0]));
            if(!list.isEmpty()) {
                startX = Math.min(startX, Math.min(list.get(0)[0], list.get(list.size()-1)[0]));
                startY = Math.min(startY, Math.min(list.get(0)[1], list.get(list.size()-1)[1]));
                endX = Math.max(endX, Math.max(list.get(0)[0], list.get(list.size()-1)[0]));
                endY = Math.max(endY, Math.max(list.get(0)[1], list.get(list.size()-1)[1]));
            }
        }
        
        answer = new String[(int)(endY - (startY - 1))];
        int idx = 0;
        for(int i = (int)(endY - startY); i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j <= (int)(endX - startX); j++) {
                boolean isDraw = false;
                for(long[] star : stars) {
                    if(star[0] == j + startX && star[1] == i + startY) {
                        sb.append("*");
                        isDraw = true;
                        break;
                    }
                }
                if(!isDraw) {
                    sb.append(".");
                }
            }
            answer[idx++] = sb.toString();
        }
        
        return answer;
    }
}