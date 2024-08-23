import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> stick = new PriorityQueue<>();
        PriorityQueue<Integer> box = new PriorityQueue<>();
        
        String[] sticks = br.readLine().split(" ");
        
        for(int i = 0; i < n; i++) {
            stick.offer(Integer.parseInt(sticks[i]));
        }
        
        String[] boxes = br.readLine().split(" ");
        
        for(int i = 0; i < n; i++) {
            box.offer(Integer.parseInt(boxes[i]));
        }
        
        while(!stick.isEmpty()) {
            if(stick.peek() <= box.peek()) {
                stick.poll();
                box.poll();
            } else {
                break;
            }
        }
        
        System.out.println(stick.isEmpty() ? "DA" : "NE");
    }
}