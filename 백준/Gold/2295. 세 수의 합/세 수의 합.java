import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);
        
        TreeSet<Integer> set = new TreeSet<>((a, b) -> b - a);
        
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length; j++) {
                set.add(arr[i] + arr[j]);
            }
        }
        
        int answer = 0;
        
        for(int i = arr.length - 1; i >= 0; i--) {
            for(int sum : set) {
                int left = 0;
                int right = arr.length-1;
                
                while(left < right) {
                    int mid = (left + right) / 2;
                    if(arr[i] == sum + arr[mid]) {
                        System.out.println(arr[i]);
                        return;
                    }
                    
                    if(arr[i] > sum + arr[mid]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
    }
}