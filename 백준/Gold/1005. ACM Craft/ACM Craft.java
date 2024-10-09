import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] cnt = new int[m+1];
            int[] time = new int[m+1];

            st = new StringTokenizer(br.readLine());

            for(int j=1; j<=m; j++) {
                time[j] = Integer.parseInt(st.nextToken());
            }

            ArrayList<ArrayList<Integer>> list = new ArrayList<>();

            for(int j=0; j<=m; j++) {
                list.add(new ArrayList<>());
            }


            for(int j=0; j<k; j++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                list.get(start).add(end);
                cnt[end]++;
            }

            int last = Integer.parseInt(br.readLine());
            boolean[] visited = new boolean[m+1];
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            
            int answer = 0;
            
            for(int j=1; j<=m; j++) {
                if(cnt[j] == 0) {
                    pq.offer(new int[] {j, time[j]});
                }
            }

            while(!pq.isEmpty()) {
                int[] cur = pq.poll();

                if(cur[0] == last) {
                    answer = cur[1];
                    break;
                }

                for(int next : list.get(cur[0])) {
                    if(!visited[next]) {
                        cnt[next]--;
                        if(cnt[next] == 0) {
                            visited[next] = true;
                            pq.offer(new int[] {next, cur[1] + time[next]});
                        }
                    }
                }
            }

            System.out.println(answer);

        }

    }
}
