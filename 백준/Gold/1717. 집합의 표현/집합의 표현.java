import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        parents = new int[n+1];
        
        for(int i=1; i<=n; i++) {
            parents[i] = i;
        }
        
        for(int i=0; i<m; i++) {
            String[] cur = br.readLine().split(" ");
            
            if(cur[0].equals("0")) {
                union(Integer.parseInt(cur[1]), Integer.parseInt(cur[2]));
            } else {
                sb.append(getParents(Integer.parseInt(cur[1])) == getParents(Integer.parseInt(cur[2])) ? "yes\n" : "no\n");
            }
        }
  
        System.out.println(sb.toString());
    }
    
    static int n;
    static int m;
    static int[] parents;
    
    public static int getParents(int x) {
        if(parents[x] == x) {
            return parents[x];
        }
        
        return parents[x] = getParents(parents[x]);
    }
    
    public static void union(int x, int y) {
        x = getParents(x);
        y = getParents(y);
        
        if(x > y) {
            parents[x] = y;
        } else {
            parents[y] = x;
        }
    }
    
}