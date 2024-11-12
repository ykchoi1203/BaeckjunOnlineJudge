import java.util.Arrays;
class Solution {
    public double solution(int[] arr) {
        return ((double)Arrays.stream(arr).average().orElse(0));
    }
}