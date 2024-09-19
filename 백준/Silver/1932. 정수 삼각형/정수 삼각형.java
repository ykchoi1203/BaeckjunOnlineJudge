import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[n][];
        
        for(int i=0; i<n; i++) {
            arr[i] = new int[i+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int j=0; j<=i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=n-2; i >= 0; i--) {
            for(int j=0; j<arr[i].length; j++) {
                arr[i][j] += Math.max(arr[i+1][j], arr[i+1][j+1]);
            }
        }
        
        System.out.println(arr[0][0]);
    }
}