import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<n; i++) {
            int nums = Integer.parseInt(br.readLine());
            String[] coins = br.readLine().split(" ");
            int money = Integer.parseInt(br.readLine());
            
            int[] dp = new int[(int)(money+1)];
            dp[0] = 1;
            for(String coin : coins) {
                for(int j= Integer.parseInt(coin); j < dp.length; j ++) {
                    if(dp[j - Integer.parseInt(coin)] != 0) {
                        dp[j] += dp[j - Integer.parseInt(coin)];
                    }
                }
            }
            System.out.println(dp[dp.length-1]);
        }
    }
}