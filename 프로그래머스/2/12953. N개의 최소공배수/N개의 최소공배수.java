class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        for(int i=1; i<arr.length; i++) {
            arr[i] = minNum(arr[i], arr[i-1]);
        }
        
        answer = arr[arr.length-1];
        
        return answer;
    }
    
    public int minNum(int n1, int n2) {
        int k = 1;
        
        int i = Math.max(n1,n2);
        int j = Math.min(n1,n2);
        while(i%j != 0) {
            k = i % j;
            i = j;
            j = k;
        }
        return n1 * n2 / j;
        
    }
}