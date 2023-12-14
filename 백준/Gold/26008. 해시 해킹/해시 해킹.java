import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int N, M, A, H;
		Scanner sc = new Scanner(System.in);

		long answer = 1L;
		N = sc.nextInt();
		M = sc.nextInt();
		A = sc.nextInt();
		H = sc.nextInt();

		for(int i=0; i<N-1; i++) {
			answer = (answer * M) % 1000000007;
		}

		System.out.println(answer);

	}
}
