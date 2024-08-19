import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int[] copyStones = Arrays.copyOf(stones, stones.length);
        Arrays.sort(copyStones);
        int l = 0;
        int r = copyStones.length - 1;
        
        while(l <= r) {
            int mid = copyStones[(l + r) / 2];
            
            boolean goLeft = false;
            int cnt = 0;
            for(int i = 0; i < stones.length; i++) {
                if(stones[i] >= mid) {
                    cnt = 0;
                } else {
                    cnt++;
                    if(cnt >= k) {
                        goLeft = true;
                        break;
                    }
                }
            }
            
            if(goLeft) {
                r = (r + l) / 2 - 1;
            } else {
                l = (r + l) / 2 + 1;
            }
        }
        
        answer = copyStones[r];
        
        return answer;
    }
}