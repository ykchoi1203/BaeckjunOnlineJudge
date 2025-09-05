import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[100][100];
        
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int startX = Integer.parseInt(st.nextToken()) - 1;
            int startY = Integer.parseInt(st.nextToken()) - 1;
            
            for(int k=startX; k < startX + 10; k++) {
                for(int j = startY; j < startY + 10; j++) {
                    arr[k][j] = true;
                }
            }
            
        }
        
        int answer = 0;
        
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(arr[i][j]) answer++;
            }
        }
        
        System.out.println(answer);
        
    }
}