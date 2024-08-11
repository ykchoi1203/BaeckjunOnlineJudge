class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] nums = new int[rows][columns];
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                nums[i][j] = i * columns + j + 1;
            }
        }
        int idx = 0;
        for(int[] query : queries) {
            answer[idx++] = change(query, nums);
        }
        
        return answer;
    }
    
    public int change(int[] query, int[][] nums) {     
        int x = query[0] - 1;
        int y = query[1];
        
        int dir = 0;
        int[][] dxdy = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int number = nums[x][y-1];
        nums[x][y-1] = nums[x+1][y-1];
        int minNum = number;
        while(x != query[0] - 1 || y != query[1] - 1) {
            int beforeNumber = nums[x][y];
            minNum = Math.min(number, minNum);
            nums[x][y] = number;
            number = beforeNumber;

            if(dir == 0 && y + 1 > query[3] - 1) {
                dir++;
            } else if(dir == 1 && x + 1 > query[2] - 1) {
                dir++;
            } else if(dir == 2 && y - 1 < query[1] - 1) {
                dir++;
            } else if(dir == 3 && x - 1 < query[0] - 1) {
                dir = 0;
            }
            x += dxdy[dir][0];
            y += dxdy[dir][1];
        }
        
        minNum = Math.min(number, minNum);
        return minNum;
    }
}