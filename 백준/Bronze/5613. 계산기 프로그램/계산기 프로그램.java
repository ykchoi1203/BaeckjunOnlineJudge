import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<String> queue = new LinkedList<>();
		long answer;

		while(true) {
			String readLine = br.readLine();
			if(readLine.equals("=")) {
				break;
			}
			queue.add(readLine);
		}
		answer = Integer.parseInt(queue.poll());

		while(!queue.isEmpty()) {
			switch (queue.poll()) {
				case "+":
					answer += Integer.parseInt(queue.poll());
					break;
				case "-":
					answer -= Integer.parseInt(queue.poll());
					break;
				case "*":
					answer *= Integer.parseInt(queue.poll());
					break;
				case "/":
					answer /= Integer.parseInt(queue.poll());
					break;
			}
		}

		System.out.println(answer);

	}
}
