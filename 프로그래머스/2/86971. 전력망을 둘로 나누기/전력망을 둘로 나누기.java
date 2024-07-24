import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        int[][] arr = new int[n+1][n+1];
        
        for(int[] wire : wires) {
            arr[wire[0]][wire[1]] = 1;
            arr[wire[1]][wire[0]] = 1;
        }
        
        for(int[] wire : wires) {
            arr[wire[0]][wire[1]] = 0;
            arr[wire[1]][wire[0]] = 0;
            
            Queue<Integer> queue = new LinkedList<>();
            queue.add(1);
            boolean[] visited = new boolean[n+1];
            int sum = 0;
            
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                
                if(!visited[cur]) {
                    for(int i=0; i<=n; i++) {
                        if(arr[cur][i] == 1 && !visited[i]) {
                            queue.add(i);
                        }
                    }
                    visited[cur] = true;
                    sum++;
                }
                
            }
            
            int others = n - sum;
            
            answer = Math.min(answer, Math.abs(others - sum));
            
            arr[wire[0]][wire[1]] = 1;
            arr[wire[1]][wire[0]] = 1;
        }
        
        return answer;
    }
    
    
}