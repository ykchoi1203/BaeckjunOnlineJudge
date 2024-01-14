import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] primeLastNum = new int[1000001];
		int[] primeNextNum = new int[1000001];
		StringBuilder sb = new StringBuilder();
		primeNextNum[1] = 2;
		int lastPrimeNum = 2;
		int nextPrimeNUm = 2;
		for(int i=3; i<primeLastNum.length; i++) {
			if(primeNum(i)) {
				primeLastNum[i] = lastPrimeNum;
				primeNextNum[nextPrimeNUm] = i;
				nextPrimeNUm = i;
				lastPrimeNum = i;
			} else {
				primeLastNum[i] = lastPrimeNum;
			}
		}

		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			boolean isTrue = true;
			int j = n;
			int i = 1;

			while (primeNextNum[i] + primeLastNum[j] != n) {
				if (primeNextNum[i] + primeLastNum[j] > n) {
					i = 1;
					j = primeLastNum[j];
				} else {
					i = primeNextNum[i];
				}

				if(primeNextNum[i] > primeLastNum[j]) {
					isTrue = false;
				}
			}
			if(!isTrue) {
				sb.append("Goldbach's conjecture is wrong.");
				continue;
			}
			sb.append(n);
			sb.append(" = ");
			sb.append(primeNextNum[i]);
			sb.append(" + ");
			sb.append(primeLastNum[j]);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static boolean primeNum(int n) {
		if(n < 2) return false;
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(n % i == 0) return false;
		}

		return true;
	}
}
