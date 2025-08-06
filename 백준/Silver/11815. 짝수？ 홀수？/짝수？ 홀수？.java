import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<n; i++) {
            long num = Long.parseLong(st.nextToken());
            sb.append(num == (long)Math.sqrt(num) * (long)Math.sqrt(num) ? 1 : 0).append(" ");
        }
        
        System.out.println(sb);
        
    }
}