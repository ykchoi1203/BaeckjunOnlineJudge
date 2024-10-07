import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        long[] arr = new long[n];
        String[] nums = br.readLine().split(" ");
        
        for(int i=0; i<arr.length; i++) {
            arr[i] = Long.parseLong(nums[i]);
        }
        
        Arrays.sort(arr);
        
        int startA = 0;
        int startB = 1;
        int last = n-1;
        
        long minA = 0;
        long minB = 0;
        long minC = 0;
        
        long min = Long.MAX_VALUE;
        
        for(int i = 0; i < n-2; i++) {
            startA = i;
            startB = i + 1;
            last = n - 1;
            while(startB < last) {
                if(min > Math.abs(arr[startA] + arr[startB] + arr[last])) {
                    min = Math.abs(arr[startA] + arr[startB] + arr[last]);
                    minA = arr[startA];
                    minB = arr[startB];
                    minC = arr[last];
                    
                    if(min == 0) {
                        System.out.println(minA + " " + minB + " " + minC);
                        return;
                    }
                }
                
                if(arr[startA] + arr[startB] + arr[last] > 0) {
                    last--;
                } else {
                    startB++;
                }
            }
        }
        
        System.out.println(minA + " " + minB + " " + minC); 
        
    }
}