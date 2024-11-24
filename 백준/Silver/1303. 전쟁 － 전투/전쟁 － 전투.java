import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        String[] s = new String[m];
        boolean[][] visited = new boolean[m][n];
        
        for(int i=0; i<m; i++) {
            s[i] = br.readLine();
        }
        
        int[] answer = new int[2];
        int[][] dxdy = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j]) {
                    char c = s[i].charAt(j);
                    int cnt = 1;
                    visited[i][j] = true;
                    
                    Queue<int[]> queue = new LinkedList<>();
                    
                    queue.add(new int[] {i, j});
                    
                    while(!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        
                        for(int[] d : dxdy) {
                            int x = cur[0] + d[0];
                            int y = cur[1] + d[1];
                            
                            if(x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && s[x].charAt(y) == c) {
                                visited[x][y] = true;
                                cnt++;
                                queue.add(new int[] {x, y});
                            }
                        }
                    }
                    
                    if(c == 'B') {
                        answer[1] += cnt * cnt;
                    } else {
                        answer[0] += cnt * cnt;
                    }
                }
            }
        }
        
        System.out.println(answer[0] + " " + answer[1]);
        
    }
}