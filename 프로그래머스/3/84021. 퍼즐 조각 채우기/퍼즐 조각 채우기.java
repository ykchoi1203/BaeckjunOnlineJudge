import java.util.*;

class Solution {
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;

        int[][] dxdy = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        boolean[][] visited = new boolean[table.length][table[0].length];

        Map<Integer, ArrayList<int[][]>> map = new HashMap<>();

        for(int i = 1; i <= 6; i++) {
            map.put(i, new ArrayList<>());
        }

        int number = 2;

        for(int i=0; i<table.length; i++) {
            for(int j=0; j<table[i].length; j++) {
                if(table[i][j] == 1 && !visited[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();
                    
                    int maxX = i;
                    int minY = j;
                    int maxY = j;
                    
                    int size = 1;
                    
                    queue.add(new int[] {i, j});
                    table[i][j] = number;
                    visited[i][j] = true;
                    
                    while(!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        
                        for(int[] dir : dxdy) {
                            int x = dir[0] + cur[0];
                            int y = dir[1] + cur[1];
                            
                            if(x >= 0 && x < table.length && y >= 0 && y < table[x].length && table[x][y] == 1 && !visited[x][y] ) {
                                queue.add(new int[] {x, y});
                                table[x][y] = number;
                                maxX = Math.max(maxX, x);
                                minY = Math.min(minY, y);
                                maxY = Math.max(maxY, y);
                                visited[x][y] = true;
                                size++;
                            }
                        }
                    }
                    
                    map.get(size).add(getDiagram(table, i, maxX, minY, maxY, number));
                    
                    number++;
                }
            }
        }

        visited = new boolean[game_board.length][game_board[0].length];
        number = 2;
        for(int i = 0; i < game_board.length; i++) {
            for(int j = 0; j < game_board[i].length; j++) {
                if(game_board[i][j] == 0 && !visited[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[] {i, j});

                    int minX = i;
                    int maxX = i;
                    int minY = j;
                    int maxY = j;

                    visited[i][j] = true;
                    game_board[i][j] = number;
                    int size = 1;

                    while(!queue.isEmpty()) {
                        int[] cur = queue.poll();

                        for(int[] dir : dxdy) {
                            int x = dir[0] + cur[0];
                            int y = dir[1] + cur[1];

                            if(x >= 0 && x < game_board.length && y >= 0 && y < game_board[x].length && game_board[x][y] == 0 && !visited[x][y]) {
                                visited[x][y] = true;
                                maxX = Math.max(maxX, x);
                                minY = Math.min(minY, y);
                                maxY = Math.max(maxY, y);
                                game_board[x][y] = number;
                                queue.add(new int[] {x, y});
                                size++;
                            }
                        }
                    }

                    int idx = -1;
                    
                    loop2:
                    for(int k = 0; k < map.get(size).size(); k++) {
                        int[][] diagram = map.get(size).get(k);
                        
                        for(int l = 0; l < 4; l++) {
                            if(isTrue(game_board, diagram, minX, maxX, minY, maxY, number)) {
                                answer += size;
                                idx = k;
                                break loop2;
                            }
                            diagram = rotate(diagram);
                        }
                    }
                    if(idx != -1) {
                        map.get(size).remove(idx);
                    }

                    number++;
                }
            }
        }

        return answer;
    }
    
    public boolean isTrue(int[][] game_board, int[][] diagram, int minX, int maxX, int minY, int maxY, int number) {
        if(diagram.length != (maxX - minX + 1) || diagram[0].length != (maxY - minY + 1)) {
            return false;
        }
        
        for(int i=minX; i<=maxX; i++) {
            for(int j = minY; j <= maxY; j++) {
                if(game_board[i][j] == number && diagram[i - minX][j - minY] == 0) {
                    return false;
                }
            }
        }
        
        return true;   
    }
    
    public int[][] rotate(int[][] diagram) {
        int[][] newDiagram = new int[diagram[0].length][diagram.length];
        
        for(int i = 0; i < newDiagram.length; i++) {
            for(int j = 0; j < newDiagram[i].length; j++) {
                newDiagram[i][j] = diagram[newDiagram[i].length - 1 - j][i];
            }
        }
        
        return newDiagram;
    }
    
    public int[][] getDiagram(int[][] table, int minX, int maxX, int minY, int maxY, int number) {
        int[][] diagram = new int[(maxX - minX + 1)][(maxY - minY + 1)];
        
        for(int i=0; i<diagram.length; i++) {
            for(int j=0; j<diagram[i].length; j++) {
                if(table[minX + i][minY + j] == number) {
                    diagram[i][j] = 1;
                }
            }
        }
        
        return diagram;
    }
}