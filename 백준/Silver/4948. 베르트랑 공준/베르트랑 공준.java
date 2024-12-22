import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = 1;
        
        int[] arr = new int[246913];
        
        arr[2] = 1;
        
        for(int i=3; i<arr.length; i++) {
            if(isTrue(i)) {
                arr[i] = arr[i-1] + 1;
            } else {
                arr[i] = arr[i-1];
            }
        }
        
        
        while(true) {
            n = Integer.parseInt(br.readLine());
            
            if(n == 0) return;
            
            System.out.println(arr[2 * n] - arr[n]);
        }
                
    }
    
    public static boolean isTrue(int k) {
        if(k % 2 == 0) return false;
        
        for(int i=3; i<= Math.sqrt(k); i+=2) {
            if(k % i == 0) return false;
        }
        
        return true;
    }
}