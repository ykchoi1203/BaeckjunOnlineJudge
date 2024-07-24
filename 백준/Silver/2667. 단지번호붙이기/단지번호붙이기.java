import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] dxdy = new int[][] {{1,0}, {0,1}, {-1,0}, {0,-1}};

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            String[] cur = br.readLine().split("");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(cur[j]);
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();

                    queue.add(new int[] {i, j});
                    int size = 0;
                    visited[i][j] = true;
                    while(!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        size++;
                        for(int[] d : dxdy) {
                            int x = cur[0] + d[0];
                            int y = cur[1] + d[1];

                            if(x >= 0 && x < N && y >= 0 && y < N && map[x][y] == 1 && !visited[x][y]) {
                                queue.add(new int[] {x, y});
                                visited[x][y] = true;
                            }
                        }
                    }
                    list.add(size);
                }
            }
        }

        List<Integer> sortList = list.stream().sorted().collect(Collectors.toList());

        System.out.println(sortList.size());

        for(int i : sortList) {
            System.out.println(i);
        }
        
    }
}