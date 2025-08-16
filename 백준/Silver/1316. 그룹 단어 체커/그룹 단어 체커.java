import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        
        loop:
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            Set<Character> set = new HashSet<>();
            
            set.add(s.charAt(0));
            
            for(int j = 1; j < s.length(); j++) {
                if(s.charAt(j - 1) != s.charAt(j)) {
                    if(!set.add(s.charAt(j))) {
                        continue loop;
                    }
                }   
            }
            
            answer++;
        }
        
        System.out.println(answer);
    }
} 