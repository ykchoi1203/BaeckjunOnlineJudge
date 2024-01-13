import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] arr = br.readLine().split(" ");
		int num = Integer.parseInt(arr[0]);
		int n = Integer.parseInt(arr[1]);
		int[] answer = new int[n];
		boolean[] visited = new boolean[num + 1];
		dfs(num, visited, 0, answer);
	}

	public static void dfs(int num, boolean[] visited, int depth, int[] answer) {
		if(depth == answer.length) {
			for(int i : answer) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}

		for(int i=1; i<=num; i++) {
			if(!visited[i]) {
				answer[depth] = i;
				visited[i] = true;
				dfs(num, visited, depth+1, answer);
				visited[i] = false;
			}
		}
	}
}
