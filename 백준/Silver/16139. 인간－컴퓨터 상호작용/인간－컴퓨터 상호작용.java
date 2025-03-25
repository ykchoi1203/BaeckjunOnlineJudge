import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] dp = new int[26][s.length() + 1];
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
            int k = s.charAt(i) - 'a';
            for(int j=0; j<26; j++) {
                dp[j][i+1] = k == j ? dp[j][i] + 1 : dp[j][i];
            }
        }
        
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int c = st.nextToken().charAt(0) - 'a';
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken()) + 1;
            
            sb.append(dp[c][b] - dp[c][a]).append("\n");
        }
        
        System.out.print(sb);
    }
}