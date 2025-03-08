import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();

        Deque<Integer> stack = new LinkedList<>();
        int idx = 0;

        for(int i=1; i<=n; i++) {
            if(arr[idx] >= i) {
                stack.push(i);
                sb.append("+\n");
            }

            while(!stack.isEmpty() && arr[idx] == stack.peek()) {
                stack.pop();
                sb.append("-\n");
                idx++;
            }
        }

        if(!stack.isEmpty()) System.out.println("NO");
        else System.out.println(sb.toString());

    }
}
