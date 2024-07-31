class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        boolean[][][] visited = new boolean[11][11][4];
        
        int x = 5;
        int y = 5;
        
        for(int i=0; i<dirs.length(); i++) {
            char c = dirs.charAt(i);
            
            switch(c) {
                case 'U' :
                    if(x > 0) {
                        x -= 1;
                        if(!visited[x][y][0]) {
                            visited[x][y][0] = true;
                            visited[x+1][y][3] = true;
                            answer++;
                        }
                    }
                    break;
                case 'L' :
                    if(y > 0) {
                        y -= 1;
                        if(!visited[x][y][1]) {
                            visited[x][y][1] = true;
                            visited[x][y+1][2] = true;
                            answer++;
                        }
                    }
                    break;
                case 'R' :
                    if(y < 10) {
                        y += 1;
                        if(!visited[x][y][2]) {
                            visited[x][y][2] = true;
                            visited[x][y-1][1] = true;
                            answer++;
                        }
                    }
                    break;
                case 'D' :
                    if(x < 10) {
                        x += 1;
                        if(!visited[x][y][3]) {
                            visited[x][y][3] = true;
                            visited[x-1][y][0] = true;
                            answer++;
                        }
                    }
            }
        }
         
        return answer;
    }
}