import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] parent = new int[n];
        
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        
        int answer = 0;
        
        for(int i=1; i<=m; i++) {
            st = new StringTokenizer(br.readLine());
        
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(getParent(parent, a) != getParent(parent, b)) {
                union(parent, a, b);
            } else if(answer == 0) {
                answer = i;
            }
        }
        
        System.out.println(answer);
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