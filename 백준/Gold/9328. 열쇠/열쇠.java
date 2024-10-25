import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());


        while(k > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int doc = 0;

            char[][] arr = new char[n][m];
            boolean[][] visited = new boolean[n][m];

            Map<Character, ArrayList<int[]>> doors = new HashMap<>();

            for(int i=0; i<n; i++) {
                String cur = br.readLine();

                for(int j=0; j<m; j++) {
                    arr[i][j] = cur.charAt(j);

                    if(arr[i][j] >= 'A' && arr[i][j] <= 'Z') {
                        if(!doors.containsKey(arr[i][j])) {
                            doors.put(arr[i][j], new ArrayList<>());
                        }

                        doors.get(arr[i][j]).add(new int[] {i, j});
                    }
                }
            }

            String keys = br.readLine();

            if(!keys.equals("0")) {
                for(char c : keys.toCharArray()) {
                    if(doors.containsKey(Character.toUpperCase(c))) {
                        for (int[] door : doors.get(Character.toUpperCase(c))) {
                            arr[door[0]][door[1]] = '.';
                        }
                    }
                }
            }

            Queue<int[]> getKeys = new LinkedList<>();

            for(int i=0; i<m; i++) {
                if(!visited[0][i] && (arr[0][i] == '.' || arr[0][i] == '$' || (arr[0][i] >= 'a' && arr[0][i] <= 'z'))) {
                    doc += bfs(arr, visited, 0, i, getKeys);
                }

                if(!visited[n-1][i] && (arr[n-1][i] == '.' || arr[n-1][i] == '$' || (arr[n-1][i] >= 'a' && arr[n-1][i] <= 'z'))) {
                    doc += bfs(arr, visited, n-1, i, getKeys);
                }
            }

            for(int i=0; i<n; i++) {
                if(!visited[i][0] && (arr[i][0] == '.' || arr[i][0] == '$' || (arr[i][0] >= 'a' && arr[i][0] <= 'z'))) {
                    doc += bfs(arr, visited, i, 0, getKeys);
                }

                if(!visited[i][m-1] && (arr[i][m-1] == '.' || arr[i][m-1] == '$' || (arr[i][m-1] >= 'a' && arr[i][m-1] <= 'z'))) {
                    doc += bfs(arr, visited, i, m-1, getKeys);
                }
            }

            while(!getKeys.isEmpty()) {
                int[] cur = getKeys.poll();

                if(doors.containsKey(Character.toUpperCase(arr[cur[0]][cur[1]]))) {
                    for (int[] door : doors.get(Character.toUpperCase(arr[cur[0]][cur[1]]))) {
                        arr[door[0]][door[1]] = '.';

                        boolean canGo = false;

                        for(int[] d : dxdy) {
                            int x = d[0] + door[0];
                            int y = d[1] + door[1];

                            if(x >= 0 && x < n && y >= 0 && y < m && visited[x][y]) {
                                canGo = true;
                                break;
                            }
                        }

                        if(door[0] == 0 || door[0] == n-1 || door[1] == 0 || door[1] == m-1) {
                            canGo = true;
                        }

                        if(canGo) {
                            visited[door[0]][door[1]] = true;

                            doc += bfs(arr, visited, door[0], door[1], getKeys);
                        }
                    }
                }
            }

            System.out.println(doc);

            k--;
        }
    }

    static int[][] dxdy = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int n;
    static int m;

    public static int bfs(char[][] arr, boolean[][] visited, int startX, int startY, Queue<int[]> getKeys) {
        Queue<int[]> queue = new LinkedList<>();
        int doc = 0;

        queue.add(new int[] {startX, startY});
        visited[startX][startY] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            if(arr[cur[0]][cur[1]] == '$') {
                doc++;
            }

            if(arr[cur[0]][cur[1]] >= 'a' && arr[cur[0]][cur[1]] <= 'z') {
                getKeys.add(new int[] {cur[0], cur[1]});
            }

            for(int[] d : dxdy) {
                int x = d[0] + cur[0];
                int y = d[1] + cur[1];

                if(x >= 0 && x < n && y >= 0 && y < m && !visited[x][y] && (arr[x][y] == '.' || arr[x][y] == '$' || (arr[x][y] >= 'a' && arr[x][y] <= 'z'))) {
                    visited[x][y] = true;
                    queue.add(new int[] {x, y});

                }
            }
        }

        return doc;
    }
}
