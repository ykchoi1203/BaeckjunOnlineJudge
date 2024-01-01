import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int answer = -1;
		boolean isTrue;

		for(int i = s.length() % 2 == 0 ? s.length()/2 - 1 : s.length()/2; i < s.length(); i++) {
			if(isOdd(s, i)) {
				answer = i * 2 + 1;
				break;
			} else if(isEven(s, i)) {
				answer = (i + 1) * 2;
				break;
			}
		}

		if(answer == -1) {
			answer = (s.length() - 1)  * 2 + 1;
		}

		System.out.println(answer);


	}

	public static boolean isOdd(String s, int i) {
		if(s.length()/2 > i) return false;
		for(int j = 1; j <s.length()-i; j++) {
			if(s.charAt(i-j) != s.charAt((i+j))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isEven(String s, int i) {
		for(int j = 0; j <s.length()-i-1; j++) {
			if(s.charAt(i-j) != s.charAt((i+j+1))) {
				return false;
			}
		}
		return true;
	}

}
