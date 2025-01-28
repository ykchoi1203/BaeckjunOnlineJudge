import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[][] move = new int[][] {{-1, -2}, {-2, -1}, {1, -2}, {2, -1},
                                    {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};
        
        while(n > 0) {
            int k = sc.nextInt();
            
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            int endX = sc.nextInt();
            int endY = sc.nextInt();
            
            boolean[][] visited = new boolean[k][k];
            
            Queue<int[]> queue = new LinkedList<>();
            visited[x][y] = true;
            queue.add(new int[] {x, y, 0});
            
            while(!queue.isEmpty()) {
                int[] cur = queue.poll();
                
                if(cur[0] == endX && cur[1]== endY) {
                    System.out.println(cur[2]);
                    break;
                }
                
                for(int[] next : move) {
                    int nextX = next[0] + cur[0];
                    int nextY = next[1] + cur[1];
                    
                    if(nextX >= 0 && nextX < k && nextY >= 0 && nextY < k && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        queue.add(new int[] {nextX, nextY, cur[2] + 1});
                    }
                }
                
            }
            
            n--;
        }
    }
}