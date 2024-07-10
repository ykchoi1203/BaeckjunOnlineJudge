import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            int idx = 0;
            for(String j : str) {
                arr[i][idx++] = Integer.parseInt(j);
            }
        }

        String[] go = br.readLine().split(" ");

        int[] roads = new int[n];
        boolean[] visited = new boolean[n];
        int k = 1;
        for(int i = 0; i<n; i++) {
            if(!visited[i]) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                while(!queue.isEmpty()) {
                    int cur = queue.poll();
                    roads[cur] = k;
                    visited[cur] = true;
                    for (int j=0; j<n; j++) {
                        if (arr[cur][j] == 1 && !visited[j]) {
                            queue.add(j);
                        }
                    }
                }
            }
            k++;
        }
        
        int curRoad = roads[Integer.parseInt(go[0])-1];
        boolean isTrue = true;
        for(String g : go) {
            if(curRoad != roads[Integer.parseInt(g)-1]) {
                System.out.println("NO");
                isTrue = false;
                break;
            }
        }

        if (isTrue) {
            System.out.println("YES");
        }
        
    }
}
