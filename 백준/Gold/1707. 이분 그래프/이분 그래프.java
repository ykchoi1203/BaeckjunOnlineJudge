import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int k = Integer.parseInt(br.readLine());
        
        while(k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            int[] arr = new int[v + 1];
            
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            
            for(int i=0; i<v+1; i++) {
                list.add(new ArrayList<>());
            }
            
            for(int i=0; i<e; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(a).add(b);
                list.get(b).add(a);
            }

            boolean answer = true;

            loop:
            for(int i=1; i<=v; i++) {
                if(arr[i] == 0) {
                    arr[i] = 1;

                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[] {i, 1});

                    while(!q.isEmpty()) {
                        int[] cur = q.poll();

                        for(int next : list.get(cur[0])) {
                            if(arr[next] == cur[1]) {
                                answer = false;
                                break loop;
                            } else if(arr[next] == 0) {
                                arr[next] = cur[1] == 1 ? 2 : 1;
                                q.add(new int[] {next, arr[next]});
                            }
                        }
                    }
                }
            }
            
            System.out.println(answer ? "YES" : "NO");
        }
        
    }
}