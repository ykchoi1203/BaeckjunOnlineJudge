import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        int[] count = new int[n + 1];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }

        int[] answer = new int[n + 1];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        for(int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            int cnt = 0;
            while(st.hasMoreTokens()) {
                int k = Integer.parseInt(st.nextToken());
                if(k == -1) break;
                count[i]++;
                cnt++;
                list.get(k).add(i);
            }

            if(cnt == 0) {
                queue.add(new int[] {i, arr[i]});
                answer[i] = arr[i];
            }
        }

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int next : list.get(cur[0])) {
                count[next]--;
                if(count[next] == 0) {
                    answer[next] = answer[cur[0]] + arr[next];
                    queue.add(new int[] {next, answer[next]});
                }
            }
        }

        for(int i=1; i<=n; i++) {
            System.out.println(answer[i]);
        }

    }
}
