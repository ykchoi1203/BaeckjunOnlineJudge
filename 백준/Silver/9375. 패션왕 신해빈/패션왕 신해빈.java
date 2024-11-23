import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<n; i++) {
            int k = Integer.parseInt(br.readLine());
            
            Map<String, Set<String>> map = new HashMap<>();
            
            for(int j=0; j<k; j++) {
                String[] c = br.readLine().split(" ");
                
                if(!map.containsKey(c[1])) {
                    map.put(c[1], new HashSet<>());
                }
                
                map.get(c[1]).add(c[0]);
            }
            
            int answer = 1;
        
            for(String key : map.keySet()) {
                answer *= map.get(key).size() + 1;
            }

            answer--;

            System.out.println(answer);
        }

    }
}