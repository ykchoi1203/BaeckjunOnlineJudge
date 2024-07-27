import java.util.*;
class Solution {
    public int solution(int[] cards) {
        boolean[] visited = new boolean[cards.length];
        int max = 0;
        int second = 0;
        
        for(int i=0; i<cards.length; i++) {
            if(!visited[i]) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                int cnt = 0;
                while(!queue.isEmpty()) {
                    int cur = queue.poll();
                    
                    if(!visited[cur]) {
                        visited[cur] = true;
                        queue.add(cards[cur]-1);
                        cnt++;
                    }
                }
                
                if(cnt >= max) {
                    second = max;
                    max = cnt;
                } else if(cnt > second) {
                    second = cnt;
                }
            }
        }
        
        return max * second;
    }
}