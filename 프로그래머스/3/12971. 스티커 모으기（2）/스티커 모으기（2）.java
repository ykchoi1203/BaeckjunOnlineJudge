class Solution {
    public int solution(int sticker[]) {
        if(sticker.length == 1) return sticker[0];
        else if(sticker.length == 2) return Math.max(sticker[0], sticker[1]);
        
        int[][] sum = new int[sticker.length][2];
        sum[0][0] = sticker[0];
        sum[0][1] = 0;
        sum[1][0] = 0;
        sum[1][1] = sticker[1];
        sum[2][0] = sum[0][0] + sticker[2];
        sum[2][1] = 0;
        
        
        for(int i=3; i<sum.length; i++) {
            sum[i][0] = Math.max(sum[i-2][0] + sticker[i], sum[i-3][0] + sticker[i]);
            sum[i][1] = Math.max(sum[i-2][1] + sticker[i], sum[i-3][1] + sticker[i]);
        }
        
        sum[sum.length-1][0] -= sticker[0];

        return Math.max(Math.max(sum[sum.length-2][0], Math.max(sum[sum.length-1][0], sum[sum.length-3][0])), 
                        Math.max(sum[sum.length-2][1], Math.max(sum[sum.length-1][1], sum[sum.length-3][1])));
    }
    
  
}