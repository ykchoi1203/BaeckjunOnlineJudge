class Solution {
    public int[] solution(int[][] users, int[] emoticons) {
        dfs(users, emoticons, 0, new int[users.length]);
        
        return answer;
    }
    
    int[] answer = new int[2];
    
    public void dfs(int[][] users, int[] emoticons, int idx, int[] emoSum) {
        if(idx >= emoticons.length) {
            int[] sum = new int[2];

            for(int i=0; i < emoSum.length; i++) {
                if(users[i][1] <= emoSum[i]) {
                    sum[0]++;
                } else {
                    sum[1] += emoSum[i];
                }
            }
            if(answer[0] < sum[0]) {
                answer[0] = sum[0];
                answer[1] = sum[1];
            } else if(answer[0] == sum[0] && answer[1] < sum[1]) {
                answer[1] = sum[1];
            }

            return;
        }

        double k = 60;
        for(int i=0; i<4; i++) {
            for(int j = 0; j < users.length; j++) {
                emoSum[j] += 100 - k >= users[j][0] ? emoticons[idx] * k / 100 : 0;
            }
            dfs(users, emoticons, idx + 1, emoSum);
            for(int j = 0; j < users.length; j++) {
                emoSum[j] -= 100 - k >= users[j][0] ? emoticons[idx] * k / 100 : 0;
            }
            k += 10;
        }
    }
}