import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for(int i = 0; i <= N; i++) {
            list.add(new HashSet<>());
        }

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        arr = new int[N + 1];
        visited = new boolean[N + 1];

        dfs(R);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<Q; i++) {
            int k = Integer.parseInt(br.readLine());

            sb.append(arr[k]).append("\n");
        }

        System.out.println(sb);

    }

    static int[] arr;
    static boolean[] visited;
    static ArrayList<Set<Integer>> list;

    public static void dfs(int idx) {
        int sum = 1;
        visited[idx] = true;

        for(int next : list.get(idx)) {
            if(!visited[next]) {
                visited[next] = true;
                dfs(next);
                sum += arr[next];
            }
        }

        arr[idx] = sum;
    }
}
