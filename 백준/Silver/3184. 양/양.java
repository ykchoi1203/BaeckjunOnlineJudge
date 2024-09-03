import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] NM = br.readLine().split(" ");
        int sheep = 0;
        int wolf = 0;
        
        String[][] arr = new String[Integer.parseInt(NM[0])][Integer.parseInt(NM[1])];
        
        for(int i = 0; i < arr.length; i++) {
            String[] str = br.readLine().split("");
            
            for(int j = 0; j < arr[i].length; j++) {
                arr[i][j] = str[j];
            }
        }
        
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int[][] dxdy = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if(!visited[i][j] && !arr[i][j].equals("#")) {
                    Queue<int[]> queue = new LinkedList<>();
                    int curSheep = 0;
                    int curWolf = 0;
                    
                    if(arr[i][j].equals("o")) {
                        curSheep = 1;
                    } else if(arr[i][j].equals("v")) {
                        curWolf = 1;
                    }
                    
                    visited[i][j] = true;
                    
                    queue.add(new int[] {i, j});
                    
                    while(!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        
                        for(int[] dir : dxdy) {
                            int x = dir[0] + cur[0];
                            int y = dir[1] + cur[1];
                            
                            if(x >= 0 && x < arr.length && y >= 0 && y < arr[x].length && !visited[x][y] && !arr[x][y].equals("#")) {
                                if(arr[x][y].equals("o")) {
                                    curSheep += 1;
                                } else if(arr[x][y].equals("v")) {
                                    curWolf += 1;
                                }
                                visited[x][y] = true;
                                queue.add(new int[] {x, y});
                            }
                        }
                    }
                    
                    if(curSheep > curWolf) {
                        sheep += curSheep;
                    } else {
                        wolf += curWolf;
                    }
                }
            }
        }
        
        System.out.println(sheep + " " + wolf);
        
    }
}