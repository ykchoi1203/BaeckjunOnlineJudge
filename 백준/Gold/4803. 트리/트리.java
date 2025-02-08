import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = 1;

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            int[] arr = new int[n + 1];

            for(int i=1; i<=n; i++) {
                arr[i] = i;
            }

            Set<Integer> set = new HashSet<>();
            Set<Integer> cycle = new HashSet<>();

            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                int pa = getParent(arr, a);
                int pb = getParent(arr, b);

                if (pa == pb) {
                    cycle.add(pa);
                } else {
                    union(arr, a, b);
                }
            }

            for(int i=1; i<=n; i++) {
                set.add(getParent(arr, i));
            }

            int cnt = set.size();

            for(int i : cycle) {
                if(set.contains(getParent(arr, i))) {
                    set.remove(getParent(arr, i));
                    cnt--;
                }
            }

            System.out.printf("Case %d: %s", num, cnt == 0 ? "No trees.\n" : cnt == 1 ? "There is one tree.\n" : "A forest of " + cnt + " trees.\n");
            num++;
        }
    }

    public static int getParent(int[] parent, int x) {
        if(parent[x] == x) {
            return x;
        }

        return parent[x] = getParent(parent, parent[x]);
    }

    public static void union(int[] parent, int x, int y) {
        x = getParent(parent, x);
        y = getParent(parent, y);

        if(x > y) {
            parent[x] = y;
        } else {
            parent[y] = x;
        }
    }
}
