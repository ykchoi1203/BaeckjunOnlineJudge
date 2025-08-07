import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if(a.length() != b.length()) return a.length() - b.length();
            return a.compareTo(b);
        });
        
        Set<String> set = new HashSet<>();
        
         for(int i = 0; i < n; i++) {
             String s = br.readLine();
             if(set.add(s)) 
                pq.add(s);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }
        
        System.out.println(sb);
        
    }
}