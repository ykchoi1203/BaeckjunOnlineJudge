import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n][m];
        
        int[] start = new int[2];
        boolean[][] visited = new boolean[n][m];
        int[][] dxdy = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int answer = 0;
        
        for(int i=0; i<n; i++) {
            String s = br.readLine();
            
            for(int j=0; j<m; j++) {
                char c = s.charAt(j);
                
                switch(c) {
                    case 'P':
                        arr[i][j] = 1;
                        break;
                    case 'X':
                        arr[i][j] = 2;
                        break;
                    case 'I':
                        start[0] = i;
                        start[1] = j;
                        visited[i][j] = true;
                        break;
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for(int[] d : dxdy) {
                int x = d[0] + cur[0];
                int y = d[1] + cur[1];
                
                if(x >= 0 && x < n && y >= 0 && y < m && !visited[x][y] && arr[x][y] != 2) {
                    q.add(new int[] {x, y});
                    visited[x][y] = true;
                    if(arr[x][y] == 1) {
                        answer++;
                    }
                }
            }
        }
        
        System.out.println(answer == 0 ? "TT" : answer);
    }
}
