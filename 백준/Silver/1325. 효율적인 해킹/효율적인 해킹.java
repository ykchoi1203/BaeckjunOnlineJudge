import java.util.*;
import java.io.*;

public class Main {   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new List[n + 1];
        result = new int[n + 1];
        visit = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            int child = sc.nextInt();
            int parent = sc.nextInt();
            arr[child].add(parent);
        }
        
        for (int i = 1; i <= n; i++) {
            visit = new boolean[n + 1];
            bfs(i);
        }
        
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, result[i]);
        }
        for (int i = 1; i <= n; i++) {
            if (result[i] == max) {
                System.out.print(i + " ");
            }
        }
    }
    
    static int n, m;
    static boolean[] visit;
    static List<Integer>[] arr;
    static int[] result;
        
    public static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visit[n] = true;
        
        while (!q.isEmpty()) {
            int num = q.poll();
            for (int i : arr[num]) {
                if (visit[i] == false) {
                    result[i]++;
                    visit[i] = true;
                    q.add(i);
                }
            }
        }
    }
}