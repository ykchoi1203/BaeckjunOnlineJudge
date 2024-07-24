import java.util.*;

class Solution {
    public int solution(String numbers) {
        String[] arr = numbers.split("");
        for(String num : arr) {
            cnt[Integer.parseInt(num)]++;
        }
        
        dfs(numbers.length(), "");
        
        return set.size();
    }
    
    Set<Integer> set = new HashSet<>();
    int[] cnt = new int[10];
    
    public void dfs(int n, String nums) {
        if(nums.length() == n) {
            return;
        }
        
        for(int i=0; i<10; i++) {
            if(nums.length() == 0 && i == 0) continue;
            if(cnt[i] > 0) {
                cnt[i]--;
                String newString = nums + Integer.toString(i);
                if(isTrue(Integer.parseInt(newString))) {
                    set.add(Integer.parseInt(newString));
                }
                dfs(n, newString);
                cnt[i]++;
            }
        }
    }
    
    public boolean isTrue(int num) {
        if(num == 2) return true;
        if(num % 2 == 0 || num == 1) return false;
        
        for(int i=3; i<=Math.sqrt(num); i+=2) {
            if(num % i == 0)
                return false;
        }
        return true;
    }
}