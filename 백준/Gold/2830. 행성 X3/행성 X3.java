import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[20];
		int target;
		long answer = 0;

		for(int i=0; i<num; i++) {
			target = Integer.parseInt(br.readLine());
			int j = 0;
			while(target > 0) {
				arr[j] += target % 2;
				target /= 2;
				j++;
			}
		}
		int j = 1;
		for(int i=0; i<arr.length; i++) {
			answer += ((long)arr[i]) * (num - arr[i]) * j;
			j *= 2;
		}

		System.out.println(answer);

	}
}
