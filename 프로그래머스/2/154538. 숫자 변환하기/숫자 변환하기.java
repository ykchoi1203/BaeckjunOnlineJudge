import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        Set<Integer> set = new HashSet<>();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[] {x, 0});
        set.add(x);
        
        while(!pq.isEmpty() && pq.peek()[0] < y) {
            int[] k = pq.poll();
            
            if(!set.contains(k[0]+n) && k[0] + n <= y) {
                set.add(k[0]+n);
                pq.add(new int[] {k[0]+n, k[1] + 1});
            }
            
            if(!set.contains(k[0]*2) && k[0] * 2 <= y) {
                set.add(k[0]*2);
                pq.add(new int[] {k[0]*2, k[1] + 1});
            }
            
            if(!set.contains(k[0]*3) && k[0] * 3 <= y) {
                set.add(k[0]*3);
                pq.add(new int[] {k[0]*3, k[1] + 1});
            }
        }
        
        if(!pq.isEmpty() && pq.peek()[0] == y) {
            return pq.peek()[1];
        }
        
        
        return -1;
    }
}