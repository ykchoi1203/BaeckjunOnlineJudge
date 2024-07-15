import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);

        long[] people = new long[times.length];
        long sum = 0;
        for(int i=0; i<people.length; i++) {
            people[i] = times[times.length-1] / times[i];
            sum += people[i];
        }

        long left;
        long right;

        if(sum >= n) {
            left = 0;
            right = times[times.length-1];
        } else {
            left = times[times.length-1];
            right = times[times.length-1] * ((n / sum) + 1);
        }

        while(left < right - 1) {
            long mid = left + (right - left) / 2;

            sum = 0;
            for(int i=0; i<people.length; i++) {
                people[i] = mid / times[i];
                sum += people[i];
            }

            if(sum >= n) {
                right = mid;
            } else {
                left = mid;
            }
        }

        answer = right;

        return answer;
    }
}