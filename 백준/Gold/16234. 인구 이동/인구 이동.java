import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n][n];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] dxdy = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int day = 0;
        while(true) {
            boolean isChange = false;
            boolean[][] visited = new boolean[n][n];
            
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(!visited[i][j]) {
                        int sum = arr[i][j];
                        ArrayList<int[]> list = new ArrayList<>();
                        Queue<int[]> queue = new LinkedList<>();
                        list.add(new int[] {i, j});
                        queue.add(new int[] {i, j});
                        visited[i][j] = true;
                        
                        while(!queue.isEmpty()) {
                            int[] cur = queue.poll();
                            
                            for(int[] d : dxdy) {
                                int x = d[0] + cur[0];
                                int y = d[1] + cur[1];
                                
                                if(x >= 0 && x < n && y >= 0 && y < n && !visited[x][y] &&
                                  Math.abs(arr[x][y] - arr[cur[0]][cur[1]]) >= l && Math.abs(arr[x][y] - arr[cur[0]][cur[1]]) <= r) {
                                    visited[x][y] = true;
                                    queue.add(new int[] {x, y});
                                    list.add(new int[] {x, y});
                                    sum += arr[x][y];
                                }
                            }
                        }
                        
                        if(list.size() > 1) {
                            int newPeople = sum / list.size();
                            
                            for(int[] cur : list) {
                                arr[cur[0]][cur[1]] = newPeople;
                            }
                            isChange = true;
                        }
                        
                    }
                }
            }
            
            if(!isChange) break;
            day++;
        }
        
        System.out.println(day);
        
    }
}