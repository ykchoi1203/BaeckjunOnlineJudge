import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        
        boolean[] visited = new boolean[dungeons.length];
        Set<Integer> set = new HashSet<>();
        dfs(k, dungeons, set);
        return answer;
    }
    
    int answer = 0;
    
    public void dfs(int k, int[][] dungeons, Set<Integer> set) {
        if(k == 0 || dungeons.length == set.size()) {
            answer = dungeons.length;
            return;
        }
        
        answer = Math.max(answer, set.size());
        
        for(int i=0; i < dungeons.length; i++) {
            if(!set.contains(i) && dungeons[i][0] <= k) {
                set.add(i);
                dfs(k - dungeons[i][1], dungeons, set);
                set.remove(i);
            }
        }
    }
}