import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[7][2];
        
        for(int i=1; i<7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int d = Integer.parseInt(st.nextToken());
            
            int dist = Integer.parseInt(st.nextToken());
            
            switch(d) {
                case 1:
                    arr[i][0] = arr[i-1][0];
                    arr[i][1] = arr[i-1][1] + dist;
                    break;
                case 2:
                    arr[i][0] = arr[i-1][0];
                    arr[i][1] = arr[i-1][1] - dist;
                    break;
                case 3:
                    arr[i][0] = arr[i-1][0] + dist;
                    arr[i][1] = arr[i-1][1];
                    break;
                default:
                    arr[i][0] = arr[i-1][0] - dist;
                    arr[i][1] = arr[i-1][1];
            } 
        }
        
        int sum = 0;
        
        for(int i=0; i<6; i++) {
            sum += arr[i][0] * arr[i+1][1];
            sum -= arr[i][1] * arr[i+1][0];
        }
        
        System.out.println(n * Math.abs(sum / 2));
    }
}