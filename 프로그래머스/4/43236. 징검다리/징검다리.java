import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        if(rocks.length == n) return distance;
        Arrays.sort(rocks);
        int[] arr = new int[rocks.length + 2];
        System.arraycopy(rocks, 0, arr, 1, rocks.length);
        arr[arr.length-1] = distance;
        int min = 1;
        int max = distance;
        
        loop:
        while(min <= max) {
            int mid = (max + min) / 2;
            int cnt = 0;
            for(int i = 1; i < arr.length; i++) {
                if(distance - arr[i] < mid && cnt + arr.length - i - 1 > n) {
                    max = mid - 1;
                    continue loop;
                }
                if(arr[i] - arr[i-1] < mid) {
                    int sum = arr[i] - arr[i-1];
                    i++;
                    while(i < arr.length && sum < mid) {
                        sum += arr[i] - arr[i-1];
                        i++;
                        cnt++;
                        if(cnt > n) {
                            max = mid - 1;
                            continue loop;
                        }
                    }
                    i--;
                    if(sum < mid && cnt == n) {
                        max = mid - 1;
                        continue loop;
                    }
                }
            }
            min = mid + 1;
        }
        
        return max;
    }
}