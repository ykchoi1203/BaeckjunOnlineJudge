import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            friends.add(new ArrayList<>());
        }
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends.get(a).add(b);
            friends.get(b).add(a);
        }
        
        for(int i=0; i<n; i++) {
            visited[i] = true;
            dfs(i, 1);
            if(isTrue) {
                System.out.println(1);
                return;
            }
            visited[i] = false;
        }
        
        System.out.println(0);
        
    }
    
    static ArrayList<ArrayList<Integer>> friends = new ArrayList<>();
    static boolean isTrue = false;
    static boolean[] visited;
    
    static void dfs(int idx, int cnt) {
        if(cnt == 5) {
            isTrue = true;
            return;
        }
        
        for(int next : friends.get(idx)) {
            if(!visited[next]) {
                visited[next] = true;
                dfs(next, cnt + 1);
                if(isTrue) return;
                visited[next] = false;
            }
        }
    }
    
}