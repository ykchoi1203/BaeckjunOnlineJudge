import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int caseNum = Integer.parseInt(bf.readLine());
		int[] answer = new int[caseNum];
		StringTokenizer st;
		int num;

		for(int i=0; i<caseNum; i++) {
			st = new StringTokenizer(bf.readLine());
			int[][] arr = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
			num = Integer.parseInt(st.nextToken());
			for(int j=0; j<num; j++) {
				st = new StringTokenizer(bf.readLine());
				arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			Queue<int[]> queue = new LinkedList();
			int cnt = 0;
			for(int j=0; j<arr.length; j++) {
				for(int k=0; k<arr[j].length; k++) {
					if(arr[j][k] == 1) {
						queue.add(new int[] {j, k});
						arr[j][k] = 0;
						while(!queue.isEmpty()) {
							int[] arr2 = queue.poll();
							if(arr2[0] - 1 >= 0 && arr[arr2[0]-1][arr2[1]] == 1) {
								queue.add(new int[] {arr2[0]-1, arr2[1]});
								arr[arr2[0]-1][arr2[1]] = 0;
							}
							if(arr2[0]+1 < arr.length && arr[arr2[0]+1][arr2[1]] == 1) {
								queue.add(new int[] {arr2[0]+1, arr2[1]});
								arr[arr2[0]+1][arr2[1]] = 0;
							}
							if(arr2[1] - 1 >= 0 && arr[arr2[0]][arr2[1]-1] == 1) {
								queue.add(new int[] {arr2[0], arr2[1]-1});
								arr[arr2[0]][arr2[1]-1] = 0;
							}
							if(arr2[1] + 1 < arr[0].length && arr[arr2[0]][arr2[1]+1] == 1) {
								queue.add(new int[] {arr2[0], arr2[1] + 1});
								arr[arr2[0]][arr2[1] + 1] = 0;
							}
						}
						cnt++;
					}
				}
			}
			answer[i] = cnt;
		}
		for(int i : answer) {
			System.out.println(i);
		}
	}
}