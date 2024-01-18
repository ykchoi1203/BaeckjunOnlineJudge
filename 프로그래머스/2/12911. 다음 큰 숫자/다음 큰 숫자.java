import java.util.*;
class Solution {
    public int solution(int n) {
        String binaryString = Integer.toBinaryString(n);
		int count = Integer.bitCount(n);

		while(true) {
            n++;
            if(Integer.bitCount(n) == count) {
                return n;
            }
        }
    }
}