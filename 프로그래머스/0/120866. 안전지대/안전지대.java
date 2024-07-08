class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int[][] dxdy = new int[][] {{0,-1}, {1,-1}, {1, 0}, {1, 1}, {0, 1}};
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] == 0) {
                    boolean isTrue = false;
                    for(int[] cur : dxdy) {
                        int x = i + cur[0];
                        int y = j + cur[1];

                        if(x >= 0 && x < board.length && y >= 0 && y < board[i].length && board[x][y] == 1) {
                            isTrue = true;
                            break;
                        }
                    }
                    if(!isTrue) {
                        answer++;
                    }
                    
                } else if(board[i][j] == 1) {
                    for(int[] cur : dxdy) {
                        int x = i + cur[0];
                        int y = j + cur[1];
                        if(x >= 0 && x < board.length && y >= 0 && y < board[i].length && board[x][y] == 0) {
                            board[x][y] = 2;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}