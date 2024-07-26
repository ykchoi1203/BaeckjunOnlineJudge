import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int[][] dxdy = new int[][] {{1,0}, {0,1}, {-1,0}, {0,-1}};

        int[][] map = new int[Integer.parseInt(NM[0])][Integer.parseInt(NM[1])];
        int[][][] count = new int[map.length][map[0].length][2];

        for(int i=0; i<map.length; i++) {
            String[] k = br.readLine().split("");

            for(int j=0; j<map[i].length; j++) {
                map[i][j] = Integer.parseInt(k[j]);
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        if(map[0][0] == 1) {
            pq.add(new int[] {1, 0, 0, 1});
            count[0][0][1] = 1;
        } else {
            pq.add(new int[] {1, 0, 0, 0});
            count[0][0][0] = 1;
        }

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();

            if(cur[1] == map.length-1 && cur[2] == map[0].length - 1) {
                break;
            }

            for(int[] d : dxdy) {
                int x = d[0] + cur[1];
                int y = d[1] + cur[2];

                if(cur[3] == 0) {
                    if(x >= 0 && map.length > x && y >= 0 && y < map[0].length
                            && (count[x][y][0] == 0 || cur[0] + 1  < count[x][y][0])) {
                        if(map[x][y] == 0) {
                            pq.add(new int[] {cur[0] + 1, x, y, 0});
                            count[x][y][0] = cur[0] + 1;
                        } else {
                            pq.add(new int[] {cur[0] + 1, x, y, 1});
                            count[x][y][1] = cur[0] + 1;
                        }
                    }
                } else {
                    if(x >= 0 && map.length > x && y >= 0 && y < map[0].length
                            && map[x][y] == 0 && (count[x][y][1] == 0 || cur[0] + 1  < count[x][y][0])) {
                        pq.add(new int[] {cur[0] + 1, x, y, 1});
                        count[x][y][1] = cur[0] + 1;
                    }
                }
            }
        }
        int answer;
        if(count[count.length-1][count[0].length-1][0] == 0 && count[count.length-1][count[0].length-1][1] == 0) {
            answer = -1;
        } else if(count[count.length-1][count[0].length-1][0] == 0) {
            answer = count[count.length-1][count[0].length-1][1];
        } else if(count[count.length-1][count[0].length-1][1] == 0) {
            answer = count[count.length-1][count[0].length-1][0];
        } else {
            answer = Math.min(count[count.length-1][count[0].length-1][0], count[count.length-1][count[0].length-1][1]);
        }

        System.out.println(answer);
        
    }
}