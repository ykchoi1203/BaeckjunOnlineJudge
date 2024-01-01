import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] arrNum = br.readLine().split(" ");
		int[][] arr = new int[Integer.parseInt(arrNum[0]) + 1][Integer.parseInt(arrNum[1]) + 1];

		for(int i=1; i<arr.length; i++) {
			arrNum = br.readLine().split(" ");

			for(int j=1; j<arr[i].length; j++) {
				if(j == 1) {
					arr[i][j] = Integer.parseInt(arrNum[j-1]);
				} else {
					arr[i][j] = arr[i][j-1] + Integer.parseInt(arrNum[j-1]);
				}
			}
		}

		int num = Integer.parseInt(br.readLine());

		int[] answer = new int[num];
		for(int i=0; i<num; i++) {
			String[] arr2 = br.readLine().split(" ");

			for(int j = Integer.parseInt(arr2[0]); j <= Integer.parseInt(arr2[2]); j++) {
				answer[i] = answer[i] + arr[j][Integer.parseInt(arr2[3])] - arr[j][Integer.parseInt(arr2[1])-1];
			}

			System.out.println(answer[i]);
		}


	}
}
