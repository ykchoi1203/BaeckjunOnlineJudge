import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int count = (picks[0] + picks[1] + picks[2]) * 5;
        
        int dpLen = minerals.length <= count ? minerals.length : count;
        
        int[] dp = new int[dpLen % 5 == 0 ? dpLen / 5 : dpLen / 5 + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[3] - a[3]);
        
        int idx = 0;
        
        for(int i=0; i<dp.length; i++) {
            int sum = 0;
            int diamond = 0;
            int iron = 0;
            int stone = 0;
            while(idx < (i + 1) * 5 && idx < minerals.length) {
                switch(minerals[idx]) {
                    case "diamond":
                        sum += 100;
                        diamond++;
                        break;
                    case "iron":
                        sum += 10;
                        iron++;
                        break;
                    case "stone":
                        sum++;
                        stone++;
                        break;
                }
                idx++;
            }
            pq.add(new int[] {diamond, iron, stone, sum});
        }
        
        idx = 0;
        
        while(!pq.isEmpty()) {
            while(idx < picks.length && picks[idx] == 0) {
                idx++;
            }
            if(idx == picks.length) break;
            int[] cur = pq.poll();
            switch(idx) {
                case 0:
                    answer += cur[0] + cur[1] + cur[2];
                    break;
                case 1:
                    answer += cur[0] * 5 + cur[1] + cur[2];
                    break;
                case 2:
                    answer += cur[0] * 25 + cur[1] * 5 + cur[2];
                    break;
            }
            picks[idx]--;
        }
        
        return answer;
    }
}