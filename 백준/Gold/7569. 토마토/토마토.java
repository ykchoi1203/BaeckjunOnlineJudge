import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] NMH = br.readLine().split(" ");
        
        int[][][] tomato = new int[Integer.parseInt(NMH[2])][Integer.parseInt(NMH[1])][Integer.parseInt(NMH[0])];
        
        for(int k=0; k<tomato.length; k++) {
            for(int i=0; i<tomato[k].length; i++) {
                String[] cur = br.readLine().split(" ");
                for(int j=0; j<cur.length; j++) {
                    tomato[k][i][j] = Integer.parseInt(cur[j]);
                }
            }
        }
        
        int[][][] visited = new int[tomato.length][tomato[0].length][tomato[0][0].length];
        int max = 0;
        int[][] dxdy = new int[][] {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, 0, 1}, {0, -1, 0}, {0, 0, -1}};
        for(int k=0; k<tomato.length; k++) {
            for(int i=0; i<tomato[k].length; i++) {
                for(int j=0; j<tomato[k][i].length; j++) {
                    if(tomato[k][i][j] == 1) {
                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[] {k, i, j, 0});
                        
                        while(!queue.isEmpty()) {
                            int[] cur = queue.poll();
                            
                            for(int[] dir : dxdy) {
                                int z = dir[0] + cur[0];
                                int x = dir[1] + cur[1];
                                int y = dir[2] + cur[2];
                                
                                if(z >= 0 && z < tomato.length && x >= 0 && x < tomato[z].length
                                  && y >= 0 && y < tomato[z][x].length && tomato[z][x][y] == 0 && (visited[z][x][y] == 0 || visited[z][x][y] > cur[3] + 1)) {
                                    queue.add(new int[] {z, x, y, cur[3] + 1});
                                    visited[z][x][y] = cur[3] + 1;
                                }
                                
                            }
                        }
                    }
                }
            }
        }
        
        loop:
        for(int k = 0; k < visited.length; k++) {
            for(int i = 0; i < visited[k].length; i++) {
                for(int j = 0; j < visited[k][i].length; j++) {
                    if(tomato[k][i][j] == 0 && visited[k][i][j] == 0) {
                        max = -1;
                        break loop;
                    }
                    max = Math.max(max, visited[k][i][j]);
                }
            }
        }
        
        System.out.println(max);
        
    }
}