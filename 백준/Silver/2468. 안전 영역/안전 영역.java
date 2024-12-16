import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        
        TreeSet<Integer> set = new TreeSet<>();
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                set.add(arr[i][j]);
            }
        }
        set.add(0);
        
        int max = 0;
        int[][] dxdy = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for(int k : set) {
            boolean[][] visited = new boolean[n][n];
            int cnt = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(arr[i][j] > k && !visited[i][j]) {
                        visited[i][j] = true;
                        
                        Queue<int[]> queue = new LinkedList<>();
                        
                        queue.add(new int[] {i, j});
                        
                        while(!queue.isEmpty()) {
                            int[] cur = queue.poll();
                            
                            for(int[] d : dxdy) {
                                int x = d[0] + cur[0];
                                int y = d[1] + cur[1];
                                
                                if(x >= 0 && x < n && y >= 0 && y < n && arr[x][y] > k && !visited[x][y]) {
                                    visited[x][y] = true;
                                    queue.add(new int[] {x, y});
                                }
                            }
                        }
                        
                        cnt++;
                    }
                }
            }
            
            max = Math.max(cnt, max);
        }
        
        System.out.println(max);
    }
}