import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        count = new int[n][n];
        group = new int[n][n];

        groupIdx = 1;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2) virus.add(new int[]{i, j});
                else if(arr[i][j] == 0) countZero++;
            }
        }

        if(countZero == 0) {
            System.out.println(0);
            return;
        }

        dfs(0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer == -1 ? 0 : answer);


    }

    static int countZero = 0;
    static int n;
    static int m;
    static int[][] arr;
    static int[][] count;
    static int[][] group;
    static int[][] dxdy = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static Map<Integer, Integer> map = new HashMap<>();
    static ArrayList<int[]> virus = new ArrayList<>();
    static int groupIdx;
    static Set<int[]> curVirus = new HashSet<>();
    static int answer = Integer.MAX_VALUE;

    static void dfs(int idx) {
        if(idx >= virus.size() || curVirus.size() == m) {
            int[][] newArr = new int[n][n];
            Queue<int[]> q = new LinkedList<>();
            for(int[] k : curVirus) {
                q.add(new int[] {k[0], k[1]});
                newArr[k[0]][k[1]] = -1;
            }
            int max = 0;
            int zeroCount = 0;
            while(!q.isEmpty()) {
                int[] cur = q.poll();

                for(int[] d : dxdy) {
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];

                    if(x >= 0 && x < n && y >= 0 && y < n && arr[x][y] != 1 && newArr[x][y] == 0) {
                        newArr[x][y] = newArr[cur[0]][cur[1]] == -1 ? 1 : newArr[cur[0]][cur[1]] + 1;
                        q.add(new int[] {x, y});
                        if(arr[x][y] == 0) {
                            max = Math.max(max, newArr[x][y]);
                            zeroCount++;
                        }
                    }
                }
            }

            if(zeroCount != countZero) return;

            answer = Math.min(max, answer);
            return;
        }

        for(int i = idx; i < virus.size(); i++) {
            curVirus.add(virus.get(i));
            dfs(i + 1);
            if(answer == -1 || answer == 0) return;
            curVirus.remove(virus.get(i));
        }
    }
}
