import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		int[][] maze = new int[N][M];
		int[][] answer = new int[N][M];

		for(int i=0; i<N; i++) {
			String line = sc.nextLine();
			for(int j=0; j<M; j++) {
				maze[i][j] = line.charAt(j) - '0';
			}
		}

		Queue<int[]> queue = new LinkedList<>();
		int[] x = {1, 0, -1, 0};
		int[] y = {0, 1, 0, -1};
		answer[0][0] = 1;
		queue.add(new int[] {0,0});

		while(!queue.isEmpty()) {
			int[] v = queue.poll();
			if(v[0] == N-1 && v[1] == M-1) break;
			for(int i=0; i<4; i++) {
				if(x[i] + v[0] >= 0 && x[i] + v[0] < N && y[i] + v[1] >= 0 && y[i] + v[1] < M) {
					if(maze[x[i] + v[0]][y[i] + v[1]] == 1) {
						if(answer[x[i] + v[0]][y[i] + v[1]] == 0 || answer[x[i] + v[0]][y[i] + v[1]] > answer[v[0]][v[1]] + 1) {
							answer[x[i] + v[0]][y[i] + v[1]] = answer[v[0]][v[1]] + 1;
							queue.add(new int[]{x[i] + v[0], y[i] + v[1]});
						}
					}
				}
			}
		}
		System.out.println(answer[N-1][M-1]);
	}
}
