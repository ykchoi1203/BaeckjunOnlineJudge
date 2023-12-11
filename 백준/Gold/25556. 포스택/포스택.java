import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num;
		boolean flag = false;

		num = sc.nextInt();

		int[] numbers = new int[num];
		Stack<Integer>[] stacks = new Stack[4];

		for(int i=0; i<num; i++) {
			numbers[i] = sc.nextInt();
		}

		for(int i = 0; i < stacks.length; i++) {
			stacks[i] = new Stack<>();
		}

		for(int i=0; i<num; i++) {
			for(int j=0; j< stacks.length; j++) {
				if(stacks[j].isEmpty()) {
					stacks[j].push(numbers[i]);
					flag = true;
					break;
				}

				if(stacks[j].peek() < numbers[i]) {
					stacks[j].push(numbers[i]);
					flag = true;
					break;
				}
			}
			if(!flag) {
				break;
			} else if(i != num - 1)flag = false;
		}

		if(flag) System.out.println("YES");
		else System.out.println("NO");

	}
}
