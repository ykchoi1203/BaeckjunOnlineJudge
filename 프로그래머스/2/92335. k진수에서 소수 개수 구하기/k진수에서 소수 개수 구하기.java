import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        while(n > 0) {
            stack.push(n % k);
            n /= k;
        }
        
        while(!stack.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            
            while(!stack.isEmpty() && stack.peek() != 0) {
                sb.append(stack.pop());
            }
            
            if(sb.length() > 0) {
                long num = Long.parseLong(sb.toString());
                if(isPrime(num)) {
                    answer++;
                }
            }
            
            while(!stack.isEmpty() && stack.peek() == 0) {
                stack.pop();
            }
        }
        
        return answer;
    }
    
    public boolean isPrime(long num) {
        
        if(num < 2) return false;
        if(num == 2) return true;
        
        for(int i=3; i <= Math.sqrt(num); i+=2) {
            if(num % i == 0)
                return false;
        }
        
        return true;
        
    }
}