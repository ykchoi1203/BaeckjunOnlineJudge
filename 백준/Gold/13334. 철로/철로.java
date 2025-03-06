import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Road[] roads = new Road[n];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            roads[i] = new Road(Math.min(start, end), Math.max(start, end));
        }

        int length = Integer.parseInt(br.readLine());

        Arrays.sort(roads);

        PriorityQueue<Road> pq = new PriorityQueue<>((a, b) -> a.start - b.start);

        int count = 0;
        int answer = 0;

        for(int i=0; i<n; i++) {
            while(!pq.isEmpty() && pq.peek().start < roads[i].end - length) {
                pq.poll();
                count--;
            }

            if(roads[i].start >= roads[i].end - length) {
                count++;
                pq.add(roads[i]);
            }

            answer = Math.max(answer, count);

        }

        System.out.println(answer);

    }



    public static class Road implements Comparable<Road> {
        int start;
        int end;

        public Road(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Road r) {
            return Integer.compare(end, r.end);
        }
    }
}
