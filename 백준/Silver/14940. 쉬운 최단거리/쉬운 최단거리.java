import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer token =new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        
        int[][] arr = new int[n][m];
        int startX = 0, startY = 0;
        for(int i=0; i<n; i++) {
            token =new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
                if(arr[i][j] == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }
        
        int[][] dxdy = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int[][] answer = new int[n][m];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY, 0});
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for(int[] dir : dxdy) {
                int x = dir[0] + cur[0];
                int y = dir[1] + cur[1];
                
                if(x >= 0 && x < n && y >= 0 && y < m && arr[x][y] != 0 && (answer[x][y] == 0 || answer[x][y] > cur[2] + 1)) {
                    if(x == startX && y == startY) continue;
                    queue.add(new int[] {x, y, cur[2] + 1});
                    answer[x][y] = cur[2] + 1;
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j] == 1 && answer[i][j] == 0) {
                    answer[i][j] = -1;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int[] cur : answer) {
            for(int num : cur) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
          
    }
}