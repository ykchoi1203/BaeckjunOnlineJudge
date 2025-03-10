import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Deque<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            String s = st.nextToken();
            
            if(s.equals("push")) {
                queue.add(Integer.parseInt(st.nextToken()));
            } else if(s.equals("pop")) {
                System.out.println(queue.isEmpty() ? -1 : queue.pollFirst());
            } else if(s.equals("size")) {
                System.out.println(queue.size());
            } else if(s.equals("front")) {
                System.out.println(queue.isEmpty() ? -1 : queue.peekFirst());
            } else if(s.equals("empty")) {
                System.out.println(queue.isEmpty() ? 1 : 0);
            } else {
                System.out.println(queue.isEmpty() ? -1 : queue.peekLast());
            }
        }
    }
}