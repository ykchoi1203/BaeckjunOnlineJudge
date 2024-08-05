class Solution {
    public int[] solution(int n) {
        if(n == 1) return new int[] {1};
        else if(n == 2) return new int[] {1,2,3};
        
        int[] answer = new int[(n * (n + 1))/2];
        int[][] maps = new int[n][];
        
        int size = 1;
        for(int i=0; i<n; i++) {
            maps[i] = new int[size++];
        }

        int i=0, j=0;
        int number = 1;
        int direction = 0;

        while(maps[i][j] == 0) {
            maps[i][j] = number++;

            if(direction == 0) {
                i++;
            } else if(direction == 1) {
                j++;
            } else {
                i--;
                j--;
            }

            if(direction == 0 && (n <= i || maps[i][j] != 0)) {
                direction = 1;
                i--;
                j++;
            } else if(direction == 1 && (n <= j || maps[i][j] != 0)) {
                direction = 2;
                j -= 2;
                i--;
            } else if(direction == 2 && maps[i][j] != 0) {
                direction = 0;
                i += 2;
                j++;
            }
        }
        
        int idx = 0;
        
        for(int[] map : maps) {
            for(int num : map) {
                answer[idx++] = num;
            }
        }
        
        return answer;
    }
    
}