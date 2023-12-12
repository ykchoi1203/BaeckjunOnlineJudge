import java.util.*;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n, m;
		int cnt = 0;
		int[] numbers;

		n = sc.nextInt();
		m = sc.nextInt();

		LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(Arrays.stream(IntStream.range(1, n+1).toArray()).boxed().toArray(Integer[]::new)));

		numbers = new int[m];
		for(int i = 0; i < m; i++) {
			numbers[i] = sc.nextInt();
		}

		for(int num : numbers) {
			cnt += count(num, linkedList);
		}
		System.out.println(cnt);
	}

	public static int count(int num, LinkedList<Integer> linkedList) {
		int cnt = 0;
		int idx = linkedList.indexOf(num);

		if(idx <= linkedList.size()/2) {
			while(linkedList.getFirst() != num) {
				linkedList.add(linkedList.removeFirst());
				cnt++;
			}
		} else {
			while(linkedList.getLast() != num) {
				linkedList.add(0, linkedList.removeLast());
				cnt++;
			}
			linkedList.add(0, linkedList.removeLast());
			cnt++;
		}
		linkedList.removeFirst();
		return cnt;
	}
}
