import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
		int answer = 1;

		int[] cnt = new int[9];
        Queue<int[]> queue = new LinkedList<>();
        int idx = 0;
        for(int i : priorities) {
            cnt[i-1]++;
            queue.add(new int[] {i-1, idx});
            idx++;
        }
        idx = 8;
        while(idx >= 0 && !queue.isEmpty()) {
            if(cnt[idx] == 0) {
                idx--;
                continue;
            }
            
            int[] cur = queue.poll();
            if(cur[0] != idx) {
                queue.add(cur);
            } else {
                if(cur[1] == location) {
                    return answer;
                } else {
                    answer++;
                    cnt[idx]--;
                }
            }
        }
        

        return answer;
    }
}