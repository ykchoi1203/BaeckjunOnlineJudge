import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++) {
            Arrays.fill(arr[i], Integer.MAX_VALUE);
            arr[i][i] = 0;
        }

        for(int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            arr[start][end] = Math.min(arr[start][end], cost);
        }

        boolean[] visited = new boolean[n];
        int[] costs = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;

        Queue<String[]> queue = new LinkedList<>();
        queue.add(new String[] {start + "", "0",(start+1) + ""});

        String answer = "";
        int answerCost = Integer.MAX_VALUE;
        int size = 0;

        while(!queue.isEmpty()) {
            String[] cur = queue.poll();

            if(Integer.parseInt(cur[0]) == end) {
                if(answerCost > Integer.parseInt(cur[1])) {
                    answerCost = Integer.parseInt(cur[1]);
                    answer = cur[2];
                    size = cur[2].split(" ").length;
                }
                continue;
            }

            int curIdx = Integer.parseInt(cur[0]);
            int curCost = Integer.parseInt(cur[1]);

            for(int i=0; i<n; i++) {
                if(i == curIdx) {
                    continue;
                } else if(arr[curIdx][i] == Integer.MAX_VALUE) {
                    continue;
                } else if(visited[i] && arr[curIdx][i] + curCost < costs[i]) {
                    costs[i] = arr[curIdx][i] + curCost;
                    queue.add(new String[] {Integer.toString(i), Integer.toString(costs[i]), cur[2] + " " + (i+1)});
                } else if(!visited[i]) {
                    costs[i] = arr[curIdx][i] + curCost;
                    visited[i] = true;
                    queue.add(new String[] {Integer.toString(i), Integer.toString(costs[i]), cur[2] + " " + (i+1)});
                }
            }

        }

        System.out.println(answerCost);
        System.out.println(size);
        System.out.println(answer);

    }
}
