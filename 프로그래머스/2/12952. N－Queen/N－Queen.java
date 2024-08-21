import java.util.*;
class Solution {
    public int solution(int n) {        
        int[] queens = new int[n];
        
        for(int i=0; i < n; i++) {
            queens[0] = i;
            dfs(queens, 1);
        }
        
        return answer;
    }
    
    int answer = 0;
    
    public void dfs(int [] queens, int idx) {
        if(idx == queens.length) {
            answer++;
            return;
        }
        
        for(int i = 0; i < queens.length; i++) {
            boolean canMove = true;
            for(int j = idx - 1; j >= 0; j--) {
                if(queens[j] == i || Math.abs(queens[j] - i) == idx - j) {
                    canMove = false;
                    break;
                }
            }
            if(canMove) {
                queens[idx] = i;
                dfs(queens, idx + 1);
            }
        }
    }
}