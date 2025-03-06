import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());

            int b;

            while((b = Integer.parseInt(st.nextToken())) != -1) {
                list.get(a).add(new int[] {b, Integer.parseInt(st.nextToken())});
            }
        }

        visited[1] = true;

        dfs(1, 0);

        visited = new boolean[n + 1];

        visited[maxIdx] = true;

        dfs(maxIdx, 0);

        System.out.println(max);

    }

    static ArrayList<ArrayList<int[]>> list = new ArrayList<>();
    static boolean[] visited = new boolean[100001];
    static int max;
    static int maxIdx;

    public static void dfs(int idx, int length) {
        if(length > max) {
            max = length;
            maxIdx = idx;
        }

        for(int[] next : list.get(idx)) {
            if(!visited[next[0]]) {
                visited[next[0]] = true;
                dfs(next[0], length + next[1]);
            }
        }
    }
}
