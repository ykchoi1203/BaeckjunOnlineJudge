import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        boolean[][][] visited = new boolean[a+1][b+1][c + 1];
        boolean[] answer = new boolean[c+1];

        visited[0][0][c] = true;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, c});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] == 0)
                answer[cur[2]] = true;
            if(cur[0] != 0) {
                int temp = cur[0] + cur[1] >= b ? cur[0] + cur[1] - b : 0;
                int next = Math.min(cur[0] + cur[1], b);

                if(!visited[temp][next][cur[2]]) {
                    visited[temp][next][cur[2]] = true;
                    q.add(new int[] {temp, next, cur[2]});
                }

                temp = cur[0] + cur[2] >= c ? cur[0] + cur[2] - c : 0;
                next = Math.min(cur[0] + cur[2], c);

                if(!visited[temp][cur[1]][next]) {
                    visited[temp][cur[1]][next] = true;

                    q.add(new int[] {temp, cur[1], next});
                }
            }

            if(cur[1] != 0) {
                int temp = cur[0] + cur[1] >= a ? cur[0] + cur[1] - a : 0;
                int next = Math.min(cur[0] + cur[1], a);

                if(!visited[next][temp][cur[2]]) {
                    visited[next][temp][cur[2]] = true;
                    q.add(new int[] {next, temp, cur[2]});
                }

                temp = cur[1] + cur[2] >= c ? cur[1] + cur[2] - c : 0;
                next = Math.min(cur[1] + cur[2], c);

                if(!visited[cur[0]][temp][next]) {
                    visited[cur[0]][temp][next] = true;
                    q.add(new int[] {cur[0], temp, next});
                }
            }

            if(cur[2] != 0) {
                int temp = cur[0] + cur[2] >= a ? cur[0] + cur[2] - a : 0;
                int next = Math.min(cur[0] + cur[2], a);

                if(!visited[next][cur[1]][temp]) {
                    visited[next][cur[1]][temp] = true;
                    q.add(new int[] {next, cur[1], temp});
                }

                temp = cur[1] + cur[2] >= b ? cur[1] + cur[2] - b : 0;
                next = Math.min(cur[1] + cur[2], b);

                if(!visited[cur[0]][next][temp]) {
                    visited[cur[0]][next][temp] = true;
                    q.add(new int[] {cur[0], next, temp});
                }
            }
        }

        for(int i=0; i<=c; i++) {
            if(answer[i]) {
                System.out.print(i + " ");
            }
        }

    }
}
