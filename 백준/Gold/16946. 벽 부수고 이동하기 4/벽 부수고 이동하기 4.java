import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int n = Integer.parseInt(NM[0]);
        int m = Integer.parseInt(NM[1]);
        int[][] arr = new int[n][m];
        int[][] visited = new int[n][m];
        int[][] dxdy = new int[][] {{1,0}, {0,1}, {-1,0}, {0,-1}};
        Map<Integer, Integer> map = new HashMap<>();
        int mapKey = 1;
        for(int i=0; i<n; i++) {
            String[] load = br.readLine().split("");

            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(load[j]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(visited[i][j] == 0 && arr[i][j] == 0) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[] {i, j});
                    visited[i][j] = mapKey;
                    int sum = 1;
                    while(!queue.isEmpty()) {
                        int[] cur = queue.poll();

                        for(int[] d : dxdy) {
                            int x = d[0] + cur[0];
                            int y = d[1] + cur[1];

                            if(x >= 0 && x < n && y >= 0 && y < m && visited[x][y] == 0 && arr[x][y] == 0) {
                                queue.add(new int[] {x, y});
                                visited[x][y] = mapKey;
                                sum++;
                            }
                        }
                    }
                    map.put(mapKey, sum % 10);
                    mapKey++;
                }

                if(i > 0 && arr[i-1][j] == 1) {
                    int sum = 1;
                    Set<Integer> set = new HashSet<>();
                    for(int[] d : dxdy) {
                        int x = d[0] + i - 1;
                        int y = d[1] + j;

                        if(x >= 0 && x < n && y >= 0 && y < m && arr[x][y] == 0 && !set.contains(visited[x][y])) {
                            sum += map.get(visited[x][y]);
                            set.add(visited[x][y]);
                        }
                    }
                    sb.append(sum % 10);
                } else if(i > 0) {
                    sb.append(0);
                }
            }
            if(i > 0)
                sb.append("\n");
        }

        for(int j=0; j<m; j++) {
            if(arr[arr.length-1][j] == 1) {
                int sum = 1;
                Set<Integer> set = new HashSet<>();
                for(int[] d : dxdy) {
                    int x = d[0] + arr.length-1;
                    int y = d[1] + j;

                    if(x >= 0 && x < n && y >= 0 && y < m && arr[x][y] == 0 && !set.contains(visited[x][y])) {
                        sum += map.get(visited[x][y]);
                        set.add(visited[x][y]);
                    }
                }
                sb.append(sum % 10);
            } else {
                sb.append(0);
            }
        }
        
        System.out.println(sb);
    }
}