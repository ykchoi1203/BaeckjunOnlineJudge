import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] arr = new int[10][];
	public static void main(String[] args) throws IOException {
		arr[0] = new int[] {10};
		arr[1] = new int[] {1};
		arr[2] = new int[] {6,2,4,8};
		arr[3] = new int[] {1,3,9,7};
		arr[4] = new int[] {6,4};
		arr[5] = new int[] {5};
		arr[6] = new int[] {6};
		arr[7] = new int[] {1,7,9,3};
		arr[8] = new int[] {6,8,4,2};
		arr[9] = new int[] {1,9};
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int caseNum = Integer.parseInt(bf.readLine());
		int[] answer = new int[caseNum];
		for(int i=0; i<caseNum; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
            if(a >= 10) a %= 10;
			int b = Integer.parseInt(st.nextToken());
			answer[i] = arr[a][b%arr[a].length];
		}

		for(int i : answer) {
			System.out.println(i);
		}
	}
}