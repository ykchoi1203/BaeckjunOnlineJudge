import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = -1;
        
        boolean[][][] visited = new boolean[board.length][board[0].length()][4];
        
        int[][] dxdy = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        int[][] intBoard = new int[visited.length][visited[0].length];
        int endX = 0, endY = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0; i<intBoard.length; i++) {
            for(int j=0; j<intBoard[i].length; j++) {
                char c = board[i].charAt(j);
                switch(c) {
                    case 'D':
                        intBoard[i][j] = 2;
                        break;
                    case 'R':
                        intBoard[i][j] = 1;
                        visited[i][j][0] = true;
                        visited[i][j][1] = true;
                        visited[i][j][2] = true;
                        visited[i][j][3] = true;
                        queue.add(new int[] {i, j, 0});
                        break;
                    case 'G':
                        endX = i;
                        endY = j;
                        break;
                }
            }
        }
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            if(cur[0] == endX && cur[1] == endY) {
                return cur[2];
            }
            
            for(int i = 0; i < 4; i++) {
                int x = cur[0];
                int y = cur[1];
                
                while(x + dxdy[i][0] >= 0 && x + dxdy[i][0] < intBoard.length && y + dxdy[i][1] >= 0 && y + dxdy[i][1] < intBoard[x].length && intBoard[x + dxdy[i][0]][y + dxdy[i][1]] != 2) {
                    x += dxdy[i][0];
                    y += dxdy[i][1];
                }
                
                if(!(x == cur[0] && y == cur[1]) && !visited[x][y][i]) {
                    queue.add(new int[] {x, y, cur[2] + 1});
                    visited[x][y][i] = true;
                }
                
            }
        }
        
        return answer;
    }
}