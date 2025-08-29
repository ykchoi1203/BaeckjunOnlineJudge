import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int x = 0, y = 0;
        int[][] arr = new int[n][n];
        
        for(int i=0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < n; j++) {
                if(s.charAt(j) == 'X') arr[i][j] = 1;
            }
        }
        
        for(int i = 0; i < n; i++) {
            int cntX = 0, cntY = 0;
            
            for(int j=0; j<n; j++) {
                if(arr[i][j] == 0) {
                    cntX++;
                    
                    if(cntX == 2) {
                        x++;
                    }
                } else cntX = 0;
                if(arr[j][i] == 0) {
                    cntY++;
                    
                    if(cntY == 2) {
                        y++;
                    }
                } else cntY = 0;
            }
        }
        
        System.out.println(x + " " + y);
          
         
    }
}