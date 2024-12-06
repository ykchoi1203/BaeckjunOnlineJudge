import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=n-1; i>=0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                arr[stack.pop()] = i+1;
            }
            
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            arr[stack.pop()] = 0;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<n; i++) {
            sb.append(arr[i]).append(' ');
        }
        
        System.out.println(sb.toString());
        
    }
}