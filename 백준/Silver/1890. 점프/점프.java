import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		int[][] arr = new int[num][num];
		long[][] visited = new long[num][num];

		for(int i=0; i<arr.length; i++) {
			String[] numbers = br.readLine().split(" ");
			for(int j=0; j<numbers.length; j++) {
				arr[i][j] = Integer.parseInt(numbers[j]);
			}
		}

		visited[0][0] = 1;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(arr[i][j] == 0) break;
				if(arr[i][j] + i < arr.length) {
					visited[i + arr[i][j]][j] += visited[i][j];
				}
				if(arr[i][j] + j < arr.length) {
					visited[i][j + arr[i][j]] += visited[i][j];
				}
			}
		}

		System.out.println(visited[num-1][num-1]);
	}

}
