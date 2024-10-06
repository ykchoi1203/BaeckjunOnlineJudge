import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        String[] arr = br.readLine().split(" ");
        
        long[] nums = new long[arr.length];
        
        for(int i=0; i<arr.length; i++) {
            nums[i] = Long.parseLong(arr[i]);
        }
        
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        long min = Long.MAX_VALUE;
        int leftAnswer = 0;
        int rightAnswer = nums.length-1;
        
        while(left < right) {
            long sum = nums[left] + nums[right];
            
            if(Math.abs(min) > Math.abs(sum)) {
                if(sum == 0) {
                    System.out.println(nums[left] + " " + nums[right]);
                    return;
                }
                min = sum;
                leftAnswer = left;
                rightAnswer = right;
            }
            
            if(Math.abs(nums[left]) > Math.abs(nums[right])) {
                left++;
            } else {
                right--;
            }
        }
        
        System.out.println(nums[leftAnswer] + " " + nums[rightAnswer]);
        
    }
}