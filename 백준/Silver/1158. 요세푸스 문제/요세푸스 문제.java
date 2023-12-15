import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input;

		int k, n;
		LinkedList<Integer> list = new LinkedList<>();
		input = bf.readLine().split(" ");
		k = Integer.parseInt(input[0]);
		n = Integer.parseInt(input[1]);

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
