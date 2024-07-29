class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[][] dxdy = new int[][] {{1,0}, {0,1}, {-1,0}, {0,-1}};
        
        for(int[] d : dxdy) {
            int x = d[0] + h;
            int y = d[1] + w;
            
            if(x >= 0 && x < board.length && y >= 0 && y < board[0].length && 
              board[h][w].equals(board[x][y])) {
                answer++;
            }
        }
        
        return answer;
    }
}