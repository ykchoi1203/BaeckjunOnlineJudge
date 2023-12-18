import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();

		int num = Integer.parseInt(br.readLine());
		String[] answer = new String[num];
		String bracket;
		for(int i=0; i<num; i++) {
			bracket = br.readLine();
			if(bracket.length() % 2 != 0) {
				answer[i] = "NO";
				continue;
			} else {
				for(int j = 0; j < bracket.length(); j++) {
					if(stack.isEmpty() && bracket.charAt(j) == ')') {
						stack.add(bracket.charAt(j));
						break;
					} else {
						if(!stack.isEmpty()) {
							if(bracket.charAt(j) == '(') {
								stack.add(bracket.charAt(j));
							} else {
								stack.pop();
							}
							if(stack.size() > bracket.length() / 2) {
								break;
							}
						} else {
							stack.add(bracket.charAt(j));
						}
					}
				}
			}
			if(stack.isEmpty()) {
				answer[i] = "YES";
			} else {
				answer[i] = "NO";
			}
			stack.clear();
		}

		for(String s : answer) {
			System.out.println(s);
		}
	}
}
