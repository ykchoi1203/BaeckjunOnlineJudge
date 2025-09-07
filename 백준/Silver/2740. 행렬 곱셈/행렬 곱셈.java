import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n][m];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[][] arr2 = new int[m][k];
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<k; j++) {
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] answer = new int[n][k];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<k; j++) {
                for(int l = 0; l < m; l++) {
                    answer[i][j] += arr[i][l] * arr2[l][j];
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<k; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}