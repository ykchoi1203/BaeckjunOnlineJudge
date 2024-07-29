import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] NM = br.readLine().split(" ");
        int m = Integer.parseInt(NM[0]);
        int n = Integer.parseInt(NM[1]);
        
        int[][] tomatos = new int[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        int[][] dxdy = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        int answer = 0;
        boolean[][] visited = new boolean[n][m];
        
        for(int i=0; i<n; i++) {
            String[] tomato = br.readLine().split(" ");
            
            for(int j=0; j<m; j++) {
                tomatos[i][j] = Integer.parseInt(tomato[j]);
                if(tomatos[i][j] == 1) {
                    pq.add(new int[] {i, j, 0});
                    visited[i][j] = true;
                }
            }
        }
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            answer = cur[2];
            for(int[] d : dxdy) {
                int x = d[0] + cur[0];
                int y = d[1] + cur[1];
                
                if(x >= 0 && x < n && y >= 0 && y < m 
                   && tomatos[x][y] == 0 && !visited[x][y]) {
                    visited[x][y] = true;
                    pq.add(new int[] {x, y, cur[2] + 1});
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[i][j] && tomatos[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            } 
        }
        
        System.out.println(answer);
        
    }
}