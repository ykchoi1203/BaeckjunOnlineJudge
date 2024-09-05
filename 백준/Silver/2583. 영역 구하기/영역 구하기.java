import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] NM = br.readLine().split(" ");
        
        int[][] arr = new int[Integer.parseInt(NM[0])][Integer.parseInt(NM[1])];
        
        for(int i=0; i < Integer.parseInt(NM[2]); i++) {
            String[] rect = br.readLine().split(" ");

            for(int j = Integer.parseInt(rect[1]); j < Integer.parseInt(rect[3]); j++) {
                for(int k = Integer.parseInt(rect[0]); k < Integer.parseInt(rect[2]); k++) {
                    arr[j][k] = 1;
                }
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int[][] dxdy = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for(int i=0; i<arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == 0 && !visited[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();
                    
                    queue.add(new int[] {i, j});
                    int size = 1;
                    visited[i][j] = true;
                    
                    while(!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        
                        for(int[] dir : dxdy) {
                            int x = dir[0] + cur[0];
                            int y = dir[1] + cur[1];
                            
                            if(x >= 0 && x < arr.length && y >= 0 && y < arr[x].length && arr[x][y] == 0 && !visited[x][y]) {
                                visited[x][y] = true;
                                queue.add(new int[] {x, y});
                                size++;
                            }
                        }
                    }
                    list.add(size);
                }
            }
        }
        
        int[] answer = new int[list.size()];
        int idx = 0;
        for(int i : list) {
            answer[idx++] = i;
        }
        
        Arrays.sort(answer);
        System.out.println(list.size());
        for(int i : answer) {
            System.out.print(i + " ");
        }
    }
}