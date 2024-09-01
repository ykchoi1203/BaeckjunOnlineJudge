import java.util.*;
class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        int x = 0;
        int y = 0;
        
        for(int[] rect : rectangle) {
            x = Math.max(rect[2], x);
            y = Math.max(rect[3], y);
        }
        
        int[][] arr = new int[x*2 + 1][y*2 + 1];
        
        for(int[] rect : rectangle) {
            for(int i = rect[0]*2; i <= rect[2] * 2; i++) {
                for(int j = rect[1]*2; j <= rect[3] * 2; j++) {
                    if((i == rect[0]*2 || i == rect[2]*2 || j == rect[1]*2 || j ==rect[3] * 2) && arr[i][j] == 0)
                        arr[i][j] = 1;
                    else arr[i][j] = 2;
                }
            }
        }
        
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == 2) {
                    if(i > 0 && j > 0 && arr[i -1][j - 1] == 0) {
                        arr[i][j] = 1;
                    } else if(i > 0 && j < arr[i].length && arr[i-1][j+1] == 0) {
                        arr[i][j] = 1;
                    } else if(i < arr.length && j > 0 && arr[i + 1][j-1] == 0) {
                        arr[i][j] = 1;
                    } else if(i < arr.length && j < arr[i].length && arr[i + 1][j + 1] == 0) {
                        arr[i][j] = 1;
                    }
                }
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        
        int[][] dxdy = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean[][] visited = new boolean[x*2 + 1][y*2 + 1];
        visited[characterX*2][characterY*2] = true;
        queue.add(new int[] {characterX * 2, characterY * 2, 0});
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for(int[] d : dxdy) {
                int newX = d[0] + cur[0];
                int newY = d[1] + cur[1];
                
                if(newX >= 0 && newX <= x*2 && newY >= 0 && newY <= y*2 && !visited[newX][newY] && arr[newX][newY] == 1) {
                    queue.add(new int[] {newX, newY, cur[2] + 1});
                    visited[newX][newY] = true;
                    if(newX == itemX * 2 && newY == itemY * 2) {
                        return (cur[2] + 1) / 2;
                    }
                }
            }
        }   
        
        return answer;
    }
}