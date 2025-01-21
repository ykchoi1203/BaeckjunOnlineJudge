import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<4; i++) {
            count[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(1, arr[0]);
        
        System.out.println(max + "\n" + min);
        
    }
    
    static int[] count = new int[4];
    static int[] arr;
    static long min = Long.MAX_VALUE;
    static long max = Long.MIN_VALUE;
    static int n;
    
    static void dfs(int idx, long answer) {
        if(n == idx) {
            min = Math.min(answer, min);
            max = Math.max(answer, max);
            return;
        }
        
        for(int i = 0; i < 4; i++) {
            if(count[i] == 0) continue;
            count[i]--;
            if(i == 0) {
                dfs(idx + 1, answer + arr[idx]);
            } else if(i == 1) {
                dfs(idx + 1, answer - arr[idx]);
            } else if(i == 2) {
                dfs(idx + 1, answer * arr[idx]);
            } else {
                dfs(idx + 1, answer / arr[idx]);
            }
            count[i]++;
        }
    }
}