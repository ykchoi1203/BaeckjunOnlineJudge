import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int time = 0;
        int w = 0;
        
        int[] d = new int[n];
        int last = -1;
        int first = 0;
        
        while(first < n) {
            time++;
            for(int j=first; j <= last; j++) {
                d[j]++;
                if(d[j] > m) {
                    first++;
                    w -= arr[j];
                }
            }
            
            if(last < n -1 && w + arr[last + 1] <= k) {
                last++;
                w += arr[last];
                d[last]++;
            }
        }
        
        System.out.println(time);
        
    }
}