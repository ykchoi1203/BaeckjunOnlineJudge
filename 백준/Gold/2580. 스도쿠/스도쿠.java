import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i=0; i<9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int j=0; j<9; j++) {
                puzzle[i][j] = Integer.parseInt(st.nextToken());
                if(puzzle[i][j] == 0) {
                    list.add(new int[] {i, j});
                }
            }
        }
        
        backTrack(0);
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                sb.append(puzzle[i][j]).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
        
    }
    
    static int[][] puzzle = new int[9][9];
    static boolean isTrue = false;
    static List<int[]> list = new ArrayList<>();
    
    static void backTrack(int idx) {
        if(isTrue) return;
        
        if(idx == list.size()) {
            isTrue = true;
            return;
        }
        
        Set<Integer> set = getCanNum(list.get(idx)[0], list.get(idx)[1]);
        
        for(int number : set) {
            puzzle[list.get(idx)[0]][list.get(idx)[1]] = number;
            backTrack(idx + 1);
            if(isTrue) return;
        }
        
        puzzle[list.get(idx)[0]][list.get(idx)[1]] = 0;
        
    }
    
    static Set<Integer> getCanNum(int x, int y) {
        Set<Integer> set = new HashSet<>();
        for(int i=1; i<=9; i++) {
            set.add(i);
        }
        
        for(int i=0; i<9; i++) {
            set.remove(puzzle[x][i]);
            set.remove(puzzle[i][y]);
        }
        
        for(int i=(x/3) * 3; i<(x/3) * 3 + 3; i++) {
            for(int j=(y/3) * 3; j<(y/3) * 3 + 3; j++) {
                set.remove(puzzle[i][j]);
            }
        }
        
        return set;
    }
    
}