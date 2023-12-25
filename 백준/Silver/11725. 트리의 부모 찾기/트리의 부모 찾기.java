import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

		int lines = Integer.parseInt(br.readLine());
		int num1, num2;
		boolean[] visited = new boolean[lines+1];
		int[] parentNode = new int[lines+1];

		for(int i=0; i<lines+1; i++) {
			tree.add(new ArrayList<>());
		}


		for(int i=0; i<lines-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num1 = Integer.parseInt(st.nextToken());
			num2 = Integer.parseInt(st.nextToken());
			tree.get(num1).add(num2);
			tree.get(num2).add(num1);
		}

		// BFS
//		Queue<Integer> queue = new LinkedList<>();
//		queue.add(1);
//		visited[1] = true;
//
//		while(!queue.isEmpty()) {
//			int v = queue.poll();
//			for(int node : tree.get(v)) {
//				if(!visited[node]) {
//					visited[node] = true;
//					parentNode[node] = v;
//					queue.add(node);
//				}
//			}
//		}

		// DFS
		dfs(1, parentNode, visited, tree);
		
		for(int i=2; i<parentNode.length; i++) {
			System.out.println(parentNode[i]);
		}

	}

	public static void dfs(int start, int[] parents, boolean[] visited, ArrayList<ArrayList<Integer>> tree) {
		for(int i=0; i<tree.get(start).size(); i++) {
			int v = tree.get(start).get(i);
			if(!visited[v]) {
				visited[v] = true;
				parents[v] = start;
				dfs(v, parents, visited, tree);
			}
		}
	}

}
