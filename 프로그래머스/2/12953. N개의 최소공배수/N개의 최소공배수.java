class Solution {
    public int solution(int[] arr) {
        if(arr.length == 1) return arr[0];
        
        int number = arr[0] * arr[1] / dfs(arr[0], arr[1]);
        
        for(int i=2; i<arr.length; i++) {
            number = number * arr[i] / dfs(number, arr[i]);
        }
        
        return number;
    }
    
    public int dfs(int a, int b) {
        if(a % b == 0)
            return b;
        return dfs(b, a % b);
    }
}