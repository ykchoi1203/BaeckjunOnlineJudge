import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n][n];
        
        for(int i=0; i<n; i++) {
            Arrays.fill(arr[i], Integer.MAX_VALUE);
            arr[i][i] = 0;
        }
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            
            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        
        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(arr[i][k] + arr[k][j] >= 0 && arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for(int i=0; i<n; i++) {
            int sum = 0;
            for(int j=0; j<n; j++) {
                sum += arr[i][j];
            }
            
            if(min > sum) {
                min = sum;
                idx = i+1;
            }
        }
        
        System.out.println(idx);
        
    }
}