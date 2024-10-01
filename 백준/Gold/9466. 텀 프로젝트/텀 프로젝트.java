import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        for(int i=0; i<n; i++) {
            int m = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            boolean[] visited = new boolean[m+1];
            Set<Integer> set = new HashSet<>();
            int[] arr = new int[m+1];

            for(int j=1; j<=m; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                if(j == arr[j]) {
                    visited[j] = true;
                    set.add(j);
                }
            }

            for(int j=1; j<=m; j++) {
                if(!visited[j]) {
                    Queue<Integer> queue = new LinkedList<>();
                    Set<Integer> visitedSet = new HashSet<>();
                    visitedSet.add(j);
                    queue.add(j);
                    visited[j] = true;

                    while(!queue.isEmpty()) {
                        int cur = queue.poll();
                        int next = arr[cur];

                        if(!visited[next] && !visitedSet.contains(next)) {
                            visitedSet.add(arr[cur]);
                            queue.add(next);
                            visited[next] = true;
                        } else if(visited[next] && visitedSet.contains(next)) {
                            while(set.add(next)) {
                                next = arr[next];
                            }
                            break;
                        }

                    }

                }
            }

            System.out.println((m - set.size()));
        }
    }

}
