import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        
        if((sum1 + sum2) % 2 != 0) return -1;
        long mid = (sum1 + sum2) / 2;
        long sum3 = sum1;
        long sum4 = sum2;
        if(sum1 > sum2) {
            int idx = 0;
            for(int i=0; i<queue1.length; i++) {
                if(sum3 == mid) return answer;
                if(sum3 < mid) {
                    if(idx < queue2.length)
                        sum3 += queue2[idx++];
                    else if(idx < queue2.length + queue1.length)
                        sum3 += queue1[idx++ - queue1.length];
                    else break;
                    answer++;
                    i--;
                    continue;
                }
                sum3 -= queue1[i];
                answer++;
            }
           
        } else {
            int idx = 0;
            for(int i=0; i<queue2.length; i++) {
                if(sum4 == mid) return answer;
                if(sum4 < mid) {
                    if(idx < queue1.length)
                        sum4 += queue1[idx++];
                    else if(idx < queue2.length + queue1.length)
                        sum4 += queue2[idx++ - queue2.length];
                    else break;
                    answer++;
                    i--;
                    continue;
                }
                sum4 -= queue2[i];
                answer++;
            }
            
        }

        return -1;
    }
}