import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int answer = 0;
        
        PriorityQueue<Integer> plus = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minus = new PriorityQueue<>((a, b) -> a - b);
        
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());
            
            if(num > 0) {
                plus.add(num);
            } else {
                minus.add(num);
            }
        }
        
        while(plus.size() > 1) {
            int i = plus.poll();
            int j = plus.poll();
            
            if(i + j > i * j) {
                answer += i + j;
            } else {
                answer += i * j;
            }
        }
        
        while(minus.size() > 1) {
            answer += minus.poll() * minus.poll();
        }
        
        if(!plus.isEmpty()) {
            answer += plus.poll();
        } 
        if(!minus.isEmpty()) {
            answer += minus.poll();
        }
        
        System.out.println(answer);
        
    }
}