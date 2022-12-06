import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][n];
		int num = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		for(int i=0; i<num; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a-1][b-1] = 1;
			arr[b-1][a-1] = 1;
		}
		boolean[] visited = new boolean[n];
		ArrayList<Integer> al = new ArrayList<>();
		dfs(arr, n, start, visited, al);
		for(int i : al) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(bfs(arr, n, start));

	}
	public static void dfs(int[][] arr, int n, int start, boolean[] visited, ArrayList<Integer> al) {
		if(al.size() == n) return;
		al.add(start);
		visited[start-1] = true;
		for(int i=0; i<arr[start-1].length; i++) {
			if(arr[start-1][i] == 1 && !visited[i]) {
				dfs(arr, n, i+1, visited, al);
			}
		}
	}
	public static String bfs(int[][] arr, int n, int start) {
		boolean[] b = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		b[start-1] = true;
		sb.append(start);
		sb.append(" ");
		queue.add(start-1);
		while(!queue.isEmpty()) {
			int k = queue.poll();
			for (int i = 0; i < arr[k].length; i++) {
				if (arr[k][i] == 1 && !b[i]) {
					queue.add(i);
					sb.append(i+1);
					sb.append(" ");
					b[i] = true;
				}
			}
		}
		return sb.toString().trim();
	}
}