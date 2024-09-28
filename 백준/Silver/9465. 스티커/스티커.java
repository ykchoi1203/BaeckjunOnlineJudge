import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            int m = Integer.parseInt(br.readLine());
            
            int[][] arr = new int[2][m];
            for(int j=0; j<2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=0; k<m; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            
            if(m == 1) {
                sb.append(Math.max(arr[0][0], arr[1][0])).append("\n");
                continue;
            }
            
            arr[0][1] += arr[1][0];
            arr[1][1] += arr[0][0];
            
            for(int j = 2; j < m; j++) {
                arr[0][j] += Math.max(arr[1][j-1], Math.max(arr[1][j-2], arr[0][j-2]));
                arr[1][j] += Math.max(arr[0][j-1], Math.max(arr[0][j-2], arr[1][j-2]));
            }
            
            sb.append(Math.max(arr[0][m-1], Math.max(arr[0][m-2], Math.max(arr[1][m-1], arr[1][m-2])))).append("\n");
        }
        
        System.out.println(sb.toString());
    }
} 