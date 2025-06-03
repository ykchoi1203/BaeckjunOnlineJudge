import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        len = s.length();
        
        for(int i = 0; i < s.length(); i++) {
            if(!dp.containsKey(s.charAt(i) - 'a')) {
                dp.put(s.charAt(i) - 'a', 0);
            }
            
            dp.put(s.charAt(i) - 'a', dp.get(s.charAt(i) - 'a') + 1);
        }
        
        dfs(0, -1);
        
        System.out.println(answer);
        
    }
    
    static Map<Integer, Integer> dp = new HashMap<>();
    static int answer = 0;
    static int len;
    
    static void dfs(int idx, int lastChar) {
        if(idx == len) {
            answer++;
            return;
        }
        
        for(int i : dp.keySet()) {
            if(lastChar == i) continue;
            if(dp.get(i) > 0) {
                dp.put(i, dp.get(i) - 1);
                dfs(idx + 1, i);
                dp.put(i, dp.get(i) + 1);
            }
        }
    }
       
}