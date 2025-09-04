import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int idx = 0;
        int sum = -1;
        
        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int[] arr = new int[5];
            
            for(int j=0; j<5; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int max = 0;
            
            for(int j = 0; j < 3; j++) {
                for(int k = j + 1; k < 4; k++) {
                    for(int l = k + 1; l < 5; l++) {
                        max = Math.max(max, (arr[j] + arr[k] + arr[l]) % 10);
                    }
                }
            }
            
            if(sum <= max) {
                sum = max;
                idx = i;
            }
        }
        
        System.out.println(idx);        
        
    }
}