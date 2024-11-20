import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        long size = 1;
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 1; i <= n; i++) {
            list.add(i);
            size *= i;
        }
        
        int[] arr = new int[n];
        k--;
        for(int i=0; i<n; i++) {
            size = size / (n - i);
            arr[i] = list.remove((int)(k / size));
            k %= size;
        }
        
        return arr;
    }
}