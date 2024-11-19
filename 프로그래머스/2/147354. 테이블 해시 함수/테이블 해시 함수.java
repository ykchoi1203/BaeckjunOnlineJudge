import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, ((a, b) -> {
            if(a[col-1] != b[col-1]) {
                return a[col-1] - b[col-1];
            }
            return b[0] - a[0];
        }));
        
        for(int i : data[row_begin-1]) {
            answer += i % row_begin;
        }

        for(int i=row_begin; i <row_end; i++) {
            int curSum = 0;
        
            for(int num : data[i]) {
                curSum += num % (i+1);
            }
            
            answer = answer ^ curSum;
        }
        
        return answer;
    }
}