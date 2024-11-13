import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] dxdy = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n][m];
        int answer = 0;
        
        List<int[]> canBuild = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0) {
                    canBuild.add(new int[] {i, j});
                }
            }
        }
        
        for(int i=0; i<canBuild.size(); i++) {
            for(int j=i+1; j < canBuild.size(); j++) {
                for(int k=j+1; k < canBuild.size(); k++) {
                    int[][] copyArr = new int[n][m];
                    boolean[][] visited = new boolean[n][m];
                    for(int l=0; l<n; l++) {
                        copyArr[l] = arr[l].clone();
                    }
                    
                    copyArr[canBuild.get(i)[0]][canBuild.get(i)[1]] = 1;
                    copyArr[canBuild.get(j)[0]][canBuild.get(j)[1]] = 1;
                    copyArr[canBuild.get(k)[0]][canBuild.get(k)[1]] = 1;
                    
                    for(int x = 0; x < n; x++) {
                        for(int y = 0; y < m; y++) {
                            if(copyArr[x][y] == 2 && !visited[x][y]) {
                                visited[x][y] = true;
                                Queue<int[]> queue = new LinkedList<>();
                                queue.add(new int[] {x, y});
                                
                                while(!queue.isEmpty()) {
                                    int[] cur = queue.poll();
                                    
                                    for(int[] d : dxdy) {
                                        int nextX = d[0] + cur[0];
                                        int nextY = d[1] + cur[1];
                                        
                                        if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m
                                          && !visited[nextX][nextY] && copyArr[nextX][nextY] != 1) {
                                            visited[nextX][nextY] = true;
                                            copyArr[nextX][nextY] = 2;
                                            queue.add(new int[] {nextX, nextY});
                                        }
                                    }
                                    
                                }
                            }
                        }
                    }
                    int sum = 0;
                    for(int x = 0; x < n; x++) {
                        for(int y = 0; y < m; y++) {
                            if(copyArr[x][y] == 0) {
                                sum++;
                            }
                        }
                    }
                    answer = Math.max(sum, answer);
                }
            }
        }
        
        System.out.println(answer);
        
    }
}