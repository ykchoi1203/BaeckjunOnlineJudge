import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n][n];
        int[] item = new int[n];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(arr[i], Integer.MAX_VALUE);
            arr[i][i] = 0;
        }
        
        for(int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int length = Integer.parseInt(st.nextToken());
            
            arr[a][b] = length;
            arr[b][a] = length;
        }
        
        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(arr[i][k] != Integer.MAX_VALUE && arr[k][j] != Integer.MAX_VALUE
                      && arr[i][k] + arr[k][j] < arr[i][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
        
        int answer = 0;
        
        for(int i=0; i<n; i++) {
            int sum = 0;
            for(int j=0; j<n; j++) {
                if(arr[i][j] <= m) {
                    sum += item[j];
                }
            }
            
            answer = Math.max(answer, sum);
        }
        
        System.out.println(answer);
        
    }
}
