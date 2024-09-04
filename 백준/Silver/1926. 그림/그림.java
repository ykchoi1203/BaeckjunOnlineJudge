import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] NM = br.readLine().split(" ");
        
        int[][] arr = new int[Integer.parseInt(NM[0])][Integer.parseInt(NM[1])];
        int[][] dxdy = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        for(int i = 0 ; i < arr.length; i++) {
            String[] num = br.readLine().split(" ");
            for(int j = 0; j < num.length; j++) {
                arr[i][j] = Integer.parseInt(num[j]);
            }
        }
        
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int count = 0;
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == 1 && !visited[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();
                    count++;
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
                    
                    max = Math.max(size, max);
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
        
    }
}