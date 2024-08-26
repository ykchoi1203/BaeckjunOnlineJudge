class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int delLastIdx = n - 1;
        int pickLastIdx = n - 1;
        int delFirstIdx = 0;
        int pickFirstIdx = 0;
        
        while(delLastIdx >= delFirstIdx || pickLastIdx >= pickFirstIdx) {
            while(delLastIdx >= 0 && deliveries[delLastIdx] == 0) {
                delLastIdx--;
            }
            while(delFirstIdx < n && deliveries[delFirstIdx] == 0) {
                delFirstIdx++;
            }
            while(pickLastIdx >= 0 && pickups[pickLastIdx] == 0) {
                pickLastIdx--;
            }
            while(pickFirstIdx < n && pickups[pickFirstIdx] == 0) {
                pickFirstIdx++;
            }
            int lastMax = Math.max(pickLastIdx, delLastIdx) + 1;
            if(delLastIdx >= 0) {
                if(deliveries[delLastIdx] >= cap) {
                    deliveries[delLastIdx] -= cap;
                } else {
                    int min = cap - deliveries[delLastIdx];
                    int idx = delLastIdx - 1;
                    deliveries[delLastIdx] = 0;
                    while(min > 0 && idx >= delFirstIdx) {
                        if(deliveries[idx] <= min) {
                            min -= deliveries[idx];
                            deliveries[idx] = 0;
                            if(idx == delFirstIdx) delFirstIdx++;
                            delLastIdx = idx;
                        } else {
                            deliveries[idx] -= min;
                            break;
                        }
                        idx--;
                    }
                }
            }
            
            if(pickLastIdx >= 0) { 
                if(pickups[pickLastIdx] >= cap) {
                    pickups[pickLastIdx] -= cap;
                } else {
                    int min = cap - pickups[pickLastIdx];
                    int idx = pickLastIdx - 1;
                    pickups[pickLastIdx] = 0;
                    while(min > 0 && idx >= pickFirstIdx) {
                        if(pickups[idx] <= min) {
                            min -= pickups[idx];
                            pickups[idx] = 0;
                            if(idx == delFirstIdx) pickFirstIdx++;
                            pickLastIdx = idx;
                        } else {
                            pickups[idx] -= min;
                            break;
                        }
                        idx--;
                    }
                }
            }
            
            answer += lastMax * 2;
        }
        
        return answer;
    }
}