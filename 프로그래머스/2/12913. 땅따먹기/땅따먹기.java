class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int idx = land[0][0] > land[0][1] ? 0 : 1;
        int nextIdx = idx == 0 ? 1 : 0;
        
        for(int i=2; i<4; i++) {
            if(land[0][idx] < land[0][i]) {
                nextIdx = idx;
                idx = i;
            } else if(land[0][nextIdx] < land[0][i]) {
                nextIdx = i;
            }
        }
        
        for(int i=1; i<land.length; i++) {
            land[i][0] += idx == 0 ? land[i-1][nextIdx] : land[i-1][idx];
            land[i][1] += idx == 1 ? land[i-1][nextIdx] : land[i-1][idx];
            
            int maxIdx = land[i][0] > land[i][1] ? 0 : 1;
            int nextMaxIdx = maxIdx == 0 ? 1 : 0;
            for(int j=2; j<4; j++) {
                land[i][j] += j == idx ? land[i-1][nextIdx] : land[i-1][idx];
                if(land[i][maxIdx] < land[i][j]) {
                    nextMaxIdx = maxIdx;
                    maxIdx = j;
                } else if(land[i][nextMaxIdx] < land[i][j]) {
                    nextMaxIdx = j;
                }
            }
            idx = maxIdx;
            nextIdx = nextMaxIdx;
        } 

        return land[land.length-1][idx];
    }
}