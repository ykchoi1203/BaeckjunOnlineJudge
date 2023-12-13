import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        TreeSet<Integer> numbers = new TreeSet<>();
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i] % divisor == 0) {
                numbers.add(arr[i]);
            }
        } 
        if(numbers.size() == 0){
            return new int[] {-1};
        }
        answer = new int[numbers.size()];
        int n = 0;
        for(int num : numbers) {
            answer[n] = num;
            n++;
        }
        
        return answer;
    }
}