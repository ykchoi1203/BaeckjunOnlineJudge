import java.util.*;
class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        Arrays.fill(answer, Integer.MAX_VALUE);
        for(int i=0; i<answer.length; i++) {
            if(balls[i][1] != startY || balls[i][0] > startX)
                answer[i] = (balls[i][0] + startX) * (balls[i][0] + startX) + (balls[i][1] - startY) * (balls[i][1] - startY);
            
            if(balls[i][1] != startY || balls[i][0] < startX)
                answer[i] = Math.min(answer[i], (2 * m - (balls[i][0] + startX)) * (2 * m - (balls[i][0] + startX)) 
                                                + (balls[i][1] - startY) * (balls[i][1] - startY));
            
            if(balls[i][0] != startX || balls[i][1] < startY)
                answer[i] = Math.min(answer[i], (balls[i][0] - startX) * (balls[i][0] - startX)
                                                + (2 * n - (balls[i][1] + startY)) * (2 * n - (balls[i][1] + startY)));
            
            if(balls[i][0] != startX || balls[i][1] > startY)
                answer[i] = Math.min(answer[i], (balls[i][0] - startX) * (balls[i][0] - startX)
                                                + ((balls[i][1] + startY)) * (balls[i][1] + startY));              
            
        }
        
        return answer;
    }
}