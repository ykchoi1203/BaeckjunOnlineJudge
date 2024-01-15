import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int[][] array;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int n = sc.nextInt();
		int m = sc.nextInt();

		array = new int[n+1][n+1];
		for(int i=1; i<array.length; i++) {
			Arrays.fill(array[i], Integer.MAX_VALUE);
			array[i][i] = 0;
		}
		for(int i=1; i<=m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if(array[a][b] > c)
				array[a][b] = c;
		}

		for(int i=1; i<=n; i++) {
			int[] answer = Floyd(i);
			for(int j = 1; j <answer.length; j++) {
				if(answer[j] == Integer.MAX_VALUE) {
					sb.append("0 ");
					continue;
				}
				sb.append(answer[j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());

	}

	public static int[] Floyd(int start) {
		int[] answer = new int[array.length];
		Arrays.fill(answer, Integer.MAX_VALUE);

		answer[start] = 0;
		answer[0] = 0;

		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[answer.length];

		queue.add(start);

		while(!queue.isEmpty()) {
			int i = queue.poll();
			int min = Integer.MAX_VALUE;
			int index=i;
			if(!visited[i]) {
				visited[i] = true;
				for (int j = 1; j < answer.length; j++) {
					if(i != j) {
						if(answer[i] + array[i][j] < answer[j] && answer[i] + array[i][j] > 0) {
							answer[j] = answer[i] + array[i][j];
						}
					}
				}
				for(int j = 1; j < answer.length; j++) {
					if(!visited[j] && min > answer[j]) {
						min = answer[j];
						index = j;
					}
				}
				queue.add(index);
			}
		}

		return answer;
	}
}
