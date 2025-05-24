import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        int[] parents = new int[n + 1];

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            list.get(parent).add(child);

            parents[child] = parent;
        }

        boolean[] visited = new boolean[n + 1];

        visited[x] = true;

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {x, 0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[0] == y) {
                System.out.println(cur[1]);
                return;
            }

            if(!visited[parents[cur[0]]]) {
                visited[parents[cur[0]]] = true;
                q.add(new int[] {parents[cur[0]], cur[1] + 1});
            }

            for(int child : list.get(cur[0])) {
                if(!visited[child]) {
                    visited[child] = true;
                    q.add(new int[] {child, cur[1] + 1});
                }
            }
        }

        System.out.println(-1);
    }

}
