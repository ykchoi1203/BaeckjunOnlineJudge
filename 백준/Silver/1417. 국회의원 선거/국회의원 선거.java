import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int my = sc.nextInt();
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for(int i = 0; i < n - 1; i++) {
            pq.add(sc.nextInt());
        }

        while(!pq.isEmpty() && pq.peek() >= my) {
            my++;
            pq.add(pq.poll()-1);
            answer++;
        }
        
        System.out.println(answer);
        
    }
}