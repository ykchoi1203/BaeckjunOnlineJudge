import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];

        for(int i = 0; i < n; i++)
            parent[i] = i;

        int[] coin = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++) {
            coin[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=1; i<=n; i++) {
            int p = getParent(i);
            if(!map.containsKey(p)) {
                map.put(p, coin[i]);
            } else {
                map.put(p, Math.min(map.get(p), coin[i]));
            }
        }

        int min = 0;

        for(int i : map.keySet()) {
            if(k - map.get(i) < 0) {
                System.out.println("Oh no");
                return;
            } else {
                k -= map.get(i);
                min += map.get(i);
            }
        }

        System.out.println(min);


    }

    static int[] parent;

    public static int getParent(int x) {
        if(parent[x] == x)
            return parent[x];
        return parent[x] = getParent(parent[x]);
    }

    public static void union(int x, int y) {
        x = getParent(x);
        y = getParent(y);

        if(x > y) {
            parent[x] = y;
        } else {
            parent[y] = x;
        }
    }
}
