import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] NM = br.readLine().split(" ");
        
        int[][] arr = new int[Integer.parseInt(NM[0])][Integer.parseInt(NM[1])];
        int[][] dxdy = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int n = Integer.parseInt(NM[2]);
        
        for(int i = 0 ; i < n; i++) {
            String[] XY = br.readLine().split(" ");
            arr[Integer.parseInt(XY[0]) - 1][Integer.parseInt(XY[1]) - 1] = 1;
        }
        
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int answer = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == 1 && !visited[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();
                    
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
                    int size = 1;
                    
                    while(!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        
                        for(int[] dir : dxdy) {
                            int x = dir[0] + cur[0];
                            int y = dir[1] + cur[1];
                            
                            if(x >= 0 && x < arr.length && y >= 0 && y < arr[x].length && arr[x][y] == 1 && !visited[x][y]) {
                                queue.add(new int[] {x, y});
                                visited[x][y] = true;
                                size++;
                            }
                        } 
                    }
                    
                    answer = Math.max(size, answer);
                }
            }
        }
        
        System.out.println(answer);
        
    }
}