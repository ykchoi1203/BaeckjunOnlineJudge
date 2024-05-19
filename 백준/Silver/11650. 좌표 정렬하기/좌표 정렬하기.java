import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        PriorityQueue<Point> queue = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<n; i++) {
            String[] nums = br.readLine().split(" ");
            queue.add(new Point(Integer.parseInt(nums[0]), Integer.parseInt(nums[1])));
        }
        
        while(!queue.isEmpty()) {
            System.out.println(queue.poll().toString());
        }
        
    }
    
    public static class Point implements Comparable<Point> {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public String toString() {
            return x + " " + y;
        }
        
        @Override
        public int compareTo(Point p) {
            if(this.x != p.x) {
                return this.x - p.x;
            } else {
                return this.y - p.y;
            }
        }
    }
}