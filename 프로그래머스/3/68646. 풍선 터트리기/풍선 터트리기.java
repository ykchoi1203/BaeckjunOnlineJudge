import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = a.length;
        
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        
        Arrays.fill(left, Integer.MAX_VALUE);
        Arrays.fill(right, Integer.MAX_VALUE);
        
        left[0] = a[0];
        right[right.length-1] = a[a.length - 1];
        
        for(int i = 1; i < a.length; i++) {
            left[i] = Math.min(left[i-1], a[i]);
            right[right.length - 1 - i] = Math.min(right[right.length - i], a[a.length - i - 1]);
        }
        
        for(int i = 1; i < a.length - 1; i++) {
            if(left[i - 1] < a[i] && right[i + 1] < a[i]) {
                answer--;
            }
        }
        
        return answer;
    }
}