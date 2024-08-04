class Solution {
    public int[] solution(int[][] arr) {
        
        dfs(arr, 0, 0, arr.length);
        
        return answer;
    }
    
    int[] answer = new int[2];
    
    public void dfs(int[][] arr, int startX, int startY, int size) {
        if(size == 1) {
            answer[arr[startX][startY]]++;
            return;
        }
        
        int number = arr[startX][startY];
        
        loop:
        for(int i=startX; i < startX + size; i++) {
            for(int j=startY; j < startY + size; j++) {
                if(number != arr[i][j]) {
                    dfs(arr, startX, startY, size/2);
                    dfs(arr, startX + size/2, startY, size/2);
                    dfs(arr, startX, startY + size/2, size/2);
                    dfs(arr, startX + size/2, startY + size/2, size/2);
                    return;
                }
            }
        }
        
        answer[number]++;
        
    }
}