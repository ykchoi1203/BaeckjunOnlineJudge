import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        len = s.length();
        
        for(int i = 0; i < s.length(); i++) {
            dp[s.charAt(i) - 'a']++;
        }
        
        dfs(0, -1);
        
        System.out.println(answer);
        
    }
    
    static int[] dp = new int[26];
    static int answer = 0;
    static int len;
    
    static void dfs(int idx, int lastChar) {
        if(idx == len) {
            answer++;
            return;
        }
        
        for(int i = 0; i < 26; i++) {
            if(lastChar == i) continue;
            if(dp[i] > 0) {
                dp[i]--;
                dfs(idx + 1, i);
                dp[i]++;
            }
        }
    }
       
}