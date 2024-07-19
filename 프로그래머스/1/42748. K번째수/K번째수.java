import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int k = 0;
        for(int[] command : commands) {
            int start = command[0]-1;
            int last = command[1];
            int idx = command[2]-1;
            
            int[] copyArray = Arrays.copyOfRange(array, start, last);
            
            Arrays.sort(copyArray);
            answer[k++] = copyArray[idx];
        }
        
        
        return answer;
    }
}