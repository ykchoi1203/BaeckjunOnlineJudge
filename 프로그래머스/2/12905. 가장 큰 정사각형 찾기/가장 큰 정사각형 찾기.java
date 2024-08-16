import java.util.*;

class Solution
{
    public int solution(int [][]board)
    {
        int answer = 1;
        
        boolean haveOne = false;
        
        loop:
        for(int i=0; i < board.length; i++) {
            for(int j=0; j < board[i].length; j++) {
                if(board[i][j] == 1) {
                    haveOne = true;
                    break loop;
                }
            }
        }
        
        if(!haveOne) return 0;
        
        for(int i = 0; i < board.length - 1; i++) {
            for(int j = 0; j < board[i].length-1; j++) {
                board[i+1][j+1] = board[i+1][j+1] == 0 ? 0 : Math.max(board[i+1][j+1], Math.min(board[i][j], Math.min(board[i+1][j], board[i][j+1])) + 1);
                answer = Math.max(board[i+1][j+1], answer);
            }
        }
        
        return answer * answer;
    }
    
}