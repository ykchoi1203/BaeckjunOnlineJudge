import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }

        int[] candies = new int[n+1];
        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++) {
            candies[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        boolean[] visited = new boolean[n+1];
        List<Group> groups = new ArrayList<>();

        for(int i=1; i<=n; i++) {
            if(!visited[i]) {
                Queue<Integer> q = new LinkedList<>();
                visited[i] = true;
                q.add(i);
                int sum = 0;
                int size = 0;

                while(!q.isEmpty()) {
                    int cur = q.poll();
                    sum += candies[cur];
                    size++;
                    for(int next : list.get(cur)) {
                        if(!visited[next]) {
                            q.add(next);
                            visited[next] = true;
                        }
                    }
                }

                groups.add(new Group(size, sum));
            }
        }

        int[][] dp = new int[groups.size() + 1][k];

        for(int i=1; i<=groups.size(); i++) {
            Group cur = groups.get(i-1);
            for(int j=1; j < k; j++) {
                if(j < cur.size) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cur.size] + cur.sum);
                }
            }
        }

        System.out.println(dp[groups.size()][k-1]);

    }

    public static class Group {
        int size = 0;
        int sum = 0;

        public Group(int size, int sum) {
            this.size = size;
            this.sum = sum;
        }
    }

}
