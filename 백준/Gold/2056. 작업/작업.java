import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] cnt = new int[n + 1];
        int[] times = new int[n + 1];
        
        ArrayList<Set<Integer>> list = new ArrayList<>();

        for(int i=0; i <= n; i++) {
            list.add(new HashSet<>());
        }
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        for(int i=1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            times[i] = time;

            int k = Integer.parseInt(st.nextToken());

            if(k != 0) {
                while(st.hasMoreTokens()) {
                    int parent = Integer.parseInt(st.nextToken());

                    cnt[i]++;
                    list.get(parent).add(i);
                }
            } else {
                queue.add(new int[] {i, times[i]});
            }
        }

        int answer = 0;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            answer = Math.max(answer, cur[1]);

            for(int next : list.get(cur[0])) {
                cnt[next]--;
                if(cnt[next] == 0) {
                    queue.add(new int[] {next, cur[1] + times[next]});
                }
            }
        }

        System.out.println(answer);
        
    }
}