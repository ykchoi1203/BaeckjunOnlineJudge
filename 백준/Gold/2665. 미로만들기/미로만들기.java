import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[n][n];
        int[][] visited = new int[n][n];
        
        for(int i=0; i<n; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
            String s = br.readLine();
            
            for(int j=0; j<n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        
        visited[0][0] = arr[0][0] == 1 ? 0 : 1;
        
        Queue<int[]> queue = new LinkedList<>();
        int[][] dxdy = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        queue.add(new int[] {0, 0, visited[0][0]});
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for(int[] d : dxdy) {
                int x = d[0] + cur[0];
                int y = d[1] + cur[1];
                
                if(x >= 0 && x < n && y >= 0 && y < n) {
                    if(arr[x][y] == 1 && visited[x][y] > cur[2]) {
                        visited[x][y] = cur[2];
                        queue.add(new int[] {x, y, cur[2]});
                    } else if(arr[x][y] == 0 && visited[x][y] > cur[2] + 1) {
                        visited[x][y] = cur[2] + 1;
                        queue.add(new int[] {x, y, cur[2] + 1});
                    }
                }
            }
        }
        
        System.out.println(visited[n-1][n-1]);
    }
}
