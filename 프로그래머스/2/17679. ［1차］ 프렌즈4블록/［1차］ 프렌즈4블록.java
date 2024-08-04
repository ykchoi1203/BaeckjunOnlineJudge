import java.util.*;
class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        int[][] dxdy = new int[][] {{0,1}, {1,0}, {1,1}};
        
        char[][] map = new char[board.length][board[0].length()];
        
        int idx = 0;
        
        for(String line : board) {
            map[idx++] = line.toCharArray();
        }
        
        
        while(true) {
            ArrayList<int[]> list = new ArrayList<>();
            for(int i=0; i<map.length-1; i++) {
                for(int j=0; j<map[i].length-1; j++) {
                    if(map[i][j] != '0' && map[i][j] == map[i][j+1] && map[i][j] == map[i+1][j] && map[i+1][j] == map[i+1][j+1]) {
                        list.add(new int[] {i, j});
                    }
                }
            }
            
            if(list.isEmpty()) {
                break;
            }
            
            for(int[] remove : list) {
                int x = remove[0];
                int y = remove[1];
                
                if(map[x][y] != '0') {
                    answer++;
                    map[x][y] = '0';
                }
                
                for(int[] d : dxdy) {
                    int dx = x + d[0];
                    int dy = y + d[1];
                    if(map[dx][dy] != '0') {
                        answer++;
                        map[dx][dy] = '0';
                    }
                }
                
            }
            
            for(int j=0; j<map[0].length; j++) {
                Stack<Character> stack = new Stack<>();
                for(int i=0; i<map.length; i++) {
                    if(map[i][j] != '0') {
                        stack.push(map[i][j]);
                    }
                }
                
                for(int i=map.length-1; i>=0; i--) {
                    if(!stack.isEmpty()) {
                        map[i][j] = stack.pop();
                    } else {
                        map[i][j] = '0';
                    }
                }
            }
            
        }
        
        return answer;
    }
}