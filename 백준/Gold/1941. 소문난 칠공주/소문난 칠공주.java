import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<5; i++) {
            String s = br.readLine();
            for(int j=0; j<s.length(); j++) {
                if(s.charAt(j) == 'S') {
                    arr[i][j] = 1;
                }
            }
            map.put(i + 1, new HashSet<>());
        }

        maps(0);

        for(int i=0; i<5; i++) {
            backTrack(i, 0, 0, i, -1);
            Arrays.fill(visited[i], false);
        }



        System.out.println(answer);

    }

    static int[][] arr = new int[5][5];
    static boolean[][] visited = new boolean[5][5];
    static boolean[] mapVisited = new boolean[5];
    static int answer = 0;
    static Map<Integer,Set<ArrayList<Integer>>> map = new HashMap<>();
    static int[][] dxdy = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static void backTrack(int x, int cnt, int sCount, int startX, int startY) {
        if(cnt == 7) {
            boolean[][] check = new boolean[5][5];
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[] {startX, startY});
            check[startX][startY] = true;
            int checkCnt = 1;

            while(!q.isEmpty()) {
                int[] cur = q.poll();

                for(int[] d : dxdy) {
                    int nextX = d[0] + cur[0];
                    int nextY = d[1] + cur[1];

                    if(nextX >= 0 && nextX < 5 && nextY >= 0 && nextY < 5 && visited[nextX][nextY] && !check[nextX][nextY]) {
                        check[nextX][nextY] = true;
                        q.add(new int[]{nextX, nextY});
                        checkCnt++;
                    }
                }
            }

            if(checkCnt != 7) return;


            if(sCount >= 4) {
                answer++;
            }

            return;
        } else if(cnt > 7) return;

        if(x == 5) return;


       for(int i=1; i<=5 && i <= 7 - cnt; i++) {
            for(ArrayList<Integer> list : map.get(i)) {
                int newCountS = 0;
                for(int j : list) {
                    visited[x][j] = true;
                    if(arr[x][j] == 1) newCountS++;
                    startX = x;
                    startY = j;
                }

                backTrack(x+1, cnt + i, sCount + newCountS, startX, startY);
                Arrays.fill(visited[x], false);

            }
           Arrays.fill(visited[x], false);
       }
    }

    static void maps(int idx) {
        if(idx == 5) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < 5; i++) {
                if(mapVisited[i]) {
                    list.add(i);
                }
            }

            if(list.isEmpty()) return;

            map.get(list.size()).add(list);
            return;
        }

        for(int i=idx; i<5; i++) {
            mapVisited[i] = true;
            maps(i + 1);
            mapVisited[i] = false;
            maps(i + 1);
        }
    }
}
