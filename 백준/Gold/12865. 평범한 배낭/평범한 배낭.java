import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] arr = br.readLine().split(" ");
		int num = Integer.parseInt(arr[0]);
		int value = Integer.parseInt(arr[1]);
		int[][] dp = new int[num+1][value+1];
		int[][] list = new int[num][2];

		int max = 0;

		for(int i=0; i<num; i++) {
			arr = br.readLine().split(" ");
			list[i][0] = Integer.parseInt(arr[0]);
			list[i][1] = Integer.parseInt(arr[1]);
		}

		for(int i=1; i<=num; i++) {
			for(int j=1; j<=value; j++) {
				if(list[i-1][0] <= j) {
					dp[i][j] = Math.max(list[i-1][1] + dp[i-1][j-list[i-1][0]], dp[i-1][j]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		System.out.println(max);

	}
}
