import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] arr = new int[Integer.parseInt(br.readLine())];
        int[] count = new int[arr.length];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.fill(count, 1);
        
        int max = 0;
        
        for(int i=0; i<arr.length; i++) {
            for(int j=i-1; j >= 0; j--) {
                if(arr[i] > arr[j] && count[i] < count[j] + 1) {
                    count[i] = count[j] + 1;
                }
                if(count[i] > j) break;
            }
            max = Math.max(max, count[i]);
        }
        
        System.out.println(max);
    }
}