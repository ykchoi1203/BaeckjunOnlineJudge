import java.util.*;

class Solution {
    public int solution(int[] order) {
        boolean[] visited = new boolean[order.length+1];
        Stack<Integer> stack = new Stack<>();
        int lastWeight = 1;
        int answer = 0;
        for(int i : order) {
            while(i >= lastWeight) {
                if(!visited[lastWeight]) {
                    visited[lastWeight] = true;
                    stack.push(lastWeight);
                    
                } 
                lastWeight++;
            }
            lastWeight--;
            if(stack.peek() == i) {
                answer++;
                stack.pop();
            } else {
                break;
            }
        }
        
        
        return answer;
    }
}