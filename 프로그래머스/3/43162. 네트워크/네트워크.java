import java.util.*;

class Solution {
   public int solution(int n, int[][] computers) {
       int[] parent = new int[n];
       
       for(int i=0; i<n; i++) {
           parent[i] = i;
       }
    
       for(int i=0; i<n; i++) {
           for(int j=0; j<n; j++) {
               if(i == j) continue;
               if(computers[i][j] == 1) {
                   union(parent, i, j);
               }
               
           }
       }
       
       Set<Integer> parents = new HashSet<>();
       
       for(int i=0; i<n; i++) {
           parents.add(find(parent, i));
       }

        return parents.size();
    }
    
    public int find(int[] parent, int x) {
        if(parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        
        return parent[x];
    }
    
    public void union(int[] parent, int x, int y) {
        x = find(parent, x);
        y = find(parent, y);
        
        if(x > y) {
            parent[x] = y;
        } else {
            parent[y] = x;
        }
    }
        
}