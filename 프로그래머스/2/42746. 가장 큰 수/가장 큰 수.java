import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        
        
        String[] stringNums = new String[numbers.length];
        int i=0;
        for(int num : numbers) {
            stringNums[i++] = Integer.toString(num);
        }
        
        Arrays.sort(stringNums, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        StringBuilder sb = new StringBuilder();
        
        if(stringNums[0].equals("0")) return "0";
        
        for(String num : stringNums) {
            sb.append(num);
        }
        
        return sb.toString();
    }
}