import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int k, n;
		LinkedList<Integer> list = new LinkedList<>();
		LinkedList<Integer> answer = new LinkedList<>();
		k = sc.nextInt();
		n = sc.nextInt();

		for(int i=1; i<=k; i++) {
			list.add(i);
		}


		sb.append("<");
		while(!list.isEmpty()) {
			for(int i=0; i<n-1; i++) {
				list.add(list.removeFirst());
			}
			sb.append(list.removeFirst() + ", ");
		}

		sb.replace(sb.length()-2, sb.length(),">");

		System.out.println(sb);

	}
}
