import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int[][] dxdy = new int[][] {{1,0}, {0,1}, {-1,0}, {0,-1}};
        int[][][] costs = new int[board.length][board[0].length][4];
        
        for(int[][] cost : costs) {
            for(int[] costMin : cost) {
                Arrays.fill(costMin, Integer.MAX_VALUE);
            }
        }
        
        costs[0][0][0] = 0;
        costs[0][0][1] = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[] {0, 0, 0, 0});
        queue.add(new int[] {0, 0, 1, 0});
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for(int i=0; i<4; i++) {
                int x = cur[0] + dxdy[i][0];
                int y = cur[1] + dxdy[i][1];
                
                if(x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 0) {
                    int newCost = i == cur[2] ? cur[3] + 100 : cur[3] + 600;
                    if(costs[x][y][i] >= newCost) {
                        queue.add(new int[] {x, y, i, newCost});
                        costs[x][y][i] = newCost;
                    }
                }
            }
        }     
        
        int answer = Integer.MAX_VALUE;
        
        for(int i=0; i<4; i++) {
            answer = Math.min(answer, costs[board.length-1][board[0].length-1][i]);
        }
        
        
        return answer;
    }
}