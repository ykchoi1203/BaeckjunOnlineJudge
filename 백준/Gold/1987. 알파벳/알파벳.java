import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] NM = br.readLine().split(" ");
        
        String[] words = new String[Integer.parseInt(NM[0])];
        
        for(int i=0; i<words.length; i++) {
            words[i] = br.readLine();
        }
        
        boolean[][] visited = new boolean[Integer.parseInt(NM[0])][Integer.parseInt(NM[1])];
        Set<Character> set = new HashSet<>();
        
        set.add(words[0].charAt(0));
        visited[0][0] = true;
        
        dfs(words, visited, 0, 0, set);
        
        System.out.println(max);
    }
    
    static int[][] dxdy = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int max = 0;
    
    public static void dfs(String[] words, boolean[][] visited, int x, int y, Set<Character> set) {
        for(int[] dir : dxdy) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            if(nextX >= 0 && nextX < words.length && nextY >= 0 && nextY < words[x].length() &&
                    !visited[nextX][nextY] && !set.contains(words[nextX].charAt(nextY))) {
                set.add(words[nextX].charAt(nextY));
                visited[nextX][nextY] = true;
                dfs(words, visited, nextX, nextY, set);
                set.remove(words[nextX].charAt(nextY));
                visited[nextX][nextY] = false;
            }
        }
        
        max = Math.max(max, set.size());
    }
}
