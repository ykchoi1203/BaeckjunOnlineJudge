import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0]- o2[0]);
        PriorityQueue<int[]> classPQ = new PriorityQueue<>((o1, o2) -> o1[1]- o2[1]);

        for(int i=0; i<N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            pq.offer(new int[]{start, end});
        }
        int time = 0;

        int answer = 0;

        while(!pq.isEmpty()) {
            time = pq.peek()[0];
            classPQ.offer(pq.poll());

            while(!classPQ.isEmpty() && classPQ.peek()[1] <= time) {
                classPQ.poll();
            }

            answer = Math.max(classPQ.size(), answer);
        }

        System.out.println(answer);

    }
}
