class Solution {
    public int solution(String[] board) {
        int answer = 1;
        
        int[][] arr = new int[3][3];
        int o = 0;
        int x = 0;
        for(int i=0; i<3; i++) {
            String[] b = board[i].split("");
            for(int j=0; j<3; j++) {
                if(b[j].equals("O")) {
                    arr[i][j] = 1;
                    o++;
                } else if(b[j].equals("X")) {
                    arr[i][j] = 2;
                    x++;
                }
            }
        }
        
        boolean oLine = isTrue(arr, 1);
        boolean xLine = isTrue(arr, 2);
        
        if(o < x || o - 1 > x) return 0;
        
        if(oLine && xLine) return 0;
        else if(xLine && o != x) return 0;
        else if(oLine && o != x + 1) return 0;
        
        return answer;
    }
    
    public boolean isTrue(int[][] arr, int j) {
        int[][][] line = new int[][][] {{{0, 0}, {0, 1}, {0, 2}}, 
                                    {{0, 0}, {1, 1}, {2, 2}},
                                    {{0, 0}, {1, 0}, {2, 0}},
                                    {{0, 1}, {1, 1}, {2, 1}},
                                    {{0, 2}, {1, 1}, {2, 0}},
                                    {{0, 2}, {1, 2}, {2, 2}},
                                    {{1, 0}, {1, 1}, {1, 2}},
                                    {{2, 0}, {2, 1}, {2, 2}}
                                   };
        
        for(int i=0; i<line.length; i++) {
            if(arr[line[i][0][0]][line[i][0][1]] == arr[line[i][1][0]][line[i][1][1]] && arr[line[i][0][0]][line[i][0][1]] == arr[line[i][2][0]][line[i][2][1]] && arr[line[i][0][0]][line[i][0][1]] == j) {
                return true;
            }
        }
        
        return false;
    }
}