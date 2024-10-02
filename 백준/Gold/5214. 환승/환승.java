import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[K][M];
        boolean[][] visited = new boolean[K][M];
        boolean[] visitedLoop = new boolean[K];
        int[] min = new int[N+1];
        Arrays.fill(min, Integer.MAX_VALUE);

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i=1; i<=N; i++) {
            map.put(i, new ArrayList<>());
        }

        Queue<int[]> queue = new LinkedList<>();

        for(int j = 0; j < K; j++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
                map.get(arr[j][i]).add(j);
                if(arr[j][i] == 1) {
                    queue.add(new int[] {1, j, 1});
                    min[1] = 1;
                    visited[j][i] = true;
                }
            }
        }


        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            if(cur[0] == N) {
                System.out.println(cur[2]);
                return;
            }

            for(int loop : map.get(cur[0])) {
                if(!visitedLoop[loop]) {
                    for (int i = 0; i < M; i++) {
                        if (!visited[loop][i] && min[arr[loop][i]] >= cur[2] + 1) {
                            queue.add(new int[]{arr[loop][i], loop, cur[2] + 1});
                            min[arr[loop][i]] = cur[2] + 1;
                            visited[loop][i] = true;
                        }
                    }
                    visitedLoop[loop] = true;
                }
            }
        }

        System.out.println("-1");
    }
}
