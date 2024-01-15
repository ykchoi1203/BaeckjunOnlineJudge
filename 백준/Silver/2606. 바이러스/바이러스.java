import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int answer = 0;
		int[][] arr = new int[N+1][N+1];
		boolean[] visited = new boolean[N+1];

		for(int i=0; i<M; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			arr[num1][num2] = 1;
			arr[num2][num1] = 1;
		}


		Queue<Integer> queue = new LinkedList<>();

		queue.add(1);
		visited[1] = true;
		while(!queue.isEmpty()) {
			int num = queue.poll();
			for(int i=1; i<=N; i++) {
				if(!visited[i] && arr[num][i] == 1) {
					queue.add(i);
					visited[i] = true;
					answer++;
				}
			}
		}

		System.out.println(answer);

	}
}
