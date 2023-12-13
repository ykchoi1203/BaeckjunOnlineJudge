import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


//		int n = sc.nextInt();
		int n = Integer.parseInt(bf.readLine());
		String[] numbers = bf.readLine().split(" ");

		long max = -1000001, min = 1000001;
		int number;
		for(int i = 0; i < n; i++) {
			number = Integer.parseInt(numbers[i]);
			if(max < number) {
				max = number;
			}
			if(min > number) {
				min = number;
			}
		}

		System.out.println(min + " " + max);

	}
}
