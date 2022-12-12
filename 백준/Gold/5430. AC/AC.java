import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static Scanner in = new Scanner(System.in);
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		ArrayDeque<Integer> deque;
		StringTokenizer st;
		int cnt = in.nextInt();
		for(int i = 0; i<cnt; i++) {
			String command = in.next();	
			int n = in.nextInt();
			st = new StringTokenizer(in.next(), "[],");
			deque = new ArrayDeque<Integer>();
			for(int j = 0; j < n; j++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			AC(command, deque);
		}
		System.out.println(sb);
	}
	public static void AC(String command, ArrayDeque<Integer> deque) {
		boolean isRight = true;

		for(char cmd : command.toCharArray()) {

			if(cmd == 'R') {
				isRight = !isRight;
				continue;
			}
			if(isRight) {
				if(deque.pollFirst() == null) {
					sb.append("error\n");
					return;
				}
			}
			else {
				if(deque.pollLast() == null) {
					sb.append("error\n");
					return;
				}
			}
		}
		makePrintString(deque, isRight);
	}

	public static void makePrintString(ArrayDeque<Integer> deque, boolean isRight) {
		sb.append('[');
		if(deque.size() > 0) {
			if(isRight) {
				sb.append(deque.pollFirst());	
				while(!deque.isEmpty()) {
					sb.append(',').append(deque.pollFirst());
				}
			}
			else {
				sb.append(deque.pollLast());
				while(!deque.isEmpty()) {
					sb.append(',').append(deque.pollLast());
				}
			}
		}
		sb.append(']').append('\n');
	}
}
