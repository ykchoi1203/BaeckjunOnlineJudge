import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] numbers = new int[n+1];

		numbers[1] = 0;

		for(int i=2; i<numbers.length; i++) {
			if(i % 2 == 0 && i % 3 == 0) {
				numbers[i] = min(numbers[i-1], numbers[i/2], numbers[i/3]) + 1;
			} else if(i % 2 == 0) {
				numbers[i] = Math.min(numbers[i-1], numbers[i/2]) + 1;
			} else if(i % 3 == 0) {
				numbers[i] = Math.min(numbers[i-1], numbers[i/3]) + 1;
			} else {
				numbers[i] = numbers[i-1] + 1;
			}

		}

		System.out.println(numbers[n]);
	}

	public static int min(int n1, int n2, int n3) {
		if(n1 <= n2 && n1<= n3) return n1;
		else if(n2 <= n1 && n2 <= n3) return n2;
		else return n3;
	}


}
