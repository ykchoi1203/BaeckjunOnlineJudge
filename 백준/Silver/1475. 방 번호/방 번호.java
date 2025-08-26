import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] arr = new int[10];
        
        String s = sc.nextLine();
        
        for(int i=0; i<s.length(); i++) {
            arr[s.charAt(i) - '0']++;
        }
        
        arr[6] += arr[9] + 1;
        arr[9] = 0;
        
        arr[6] /= 2;
        
        int max = 0;
        
        for(int i=0; i<10; i++)
            max = Math.max(arr[i], max);
        
        System.out.println(max);
        
    }
}