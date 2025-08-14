import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        long sum = 0;
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int c = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            sum += c * k;
        }
        
        System.out.println(sum);
        
    }
}