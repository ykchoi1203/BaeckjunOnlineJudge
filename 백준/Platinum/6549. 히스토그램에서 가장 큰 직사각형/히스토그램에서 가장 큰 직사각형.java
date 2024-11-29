import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int x;
        while(true) {
            x = sc.nextInt();
            if(x == 0) return;
            long[] heights = new long[x];
            int max = 0;
            for(int i=0; i<x; i++) {
                heights[i] = sc.nextLong();
            }

            System.out.println(solution(heights));
        }
        
    }
 
    public static long solution(long[] heights) {
        long answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= heights.length; i++) {
            long currHeight = (i == heights.length) ? 0 : heights[i];

            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                long height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                answer = Math.max(answer, height * width);
            }

            stack.push(i);
        }

        return answer;
    }
}