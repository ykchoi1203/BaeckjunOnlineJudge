import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] A = br.readLine().split(" ");
		int[] arr = Arrays.stream(br.readLine().split(" ")).flatMapToInt(m -> IntStream.of(Integer.parseInt(m))).toArray();
		int answer = 0;
		int sum;
		for(int i=0; i<arr.length; i++) {
			sum = 0;
			for(int j=i; j<arr.length; j++) {
				sum+= arr[j];
				if(sum == Integer.parseInt(A[1])) {
					answer++;
					break;
				} else if(sum > Integer.parseInt(A[1])) {
					break;
				}
			}
		}

		System.out.println(answer);

	}
}
