import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long max = -1000001, min = 1000001;
		int number;
		for(int i = 0; i < n; i++) {
			number = sc.nextInt();
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
