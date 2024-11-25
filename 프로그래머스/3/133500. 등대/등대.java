import java.util.*;

class Solution {
    public int solution(int n, int[][] lighthouse) {
        int answer = 0;
        
        int[] dp = new int[n + 1];
        
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i=1; i<=n; i++) {
            map.put(i, new ArrayList<>());
        }
        
        for(int[] light : lighthouse) {
            dp[light[0]]++;
            dp[light[1]]++;
            map.get(light[0]).add(light[1]);
            map.get(light[1]).add(light[0]);
        }
        
        int cnt = n;
        
        while(cnt > 0) {
            int min = n;
            int idx = 0;
            for(int i=1; i<=n; i++) {
                if(min > dp[i] && dp[i] > 0) {
                    min = dp[i]; 
                    idx = i;
                    if(min == 1) break;
                }
            }
            
            if(min == n) break;
            
            answer++;
            cnt--;
            dp[idx] = 0;
            
            int nextIdx = 0;
            
            for(int light : map.get(idx)) {
                if(dp[light] >= 1) {
                    nextIdx = light;
                    break;
                }
            }
            
            for(int light : map.get(nextIdx)) {
                dp[light]--;
            }
            
            dp[nextIdx] = 0;
            cnt--;
            
        }
        
        return answer;
    }
}