import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while(n > 0) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            int[] arr = new int[10001];

            Arrays.fill(arr, Integer.MAX_VALUE);

            arr[start] = 0;

            Queue<Node> queue = new LinkedList<>();

            queue.add(new Node(start, 0, ""));

            while(!queue.isEmpty()) {
                Node cur = queue.poll();

                if(cur.number == end) {
                    sb.append(cur.s).append("\n");
                    break;
                }

                int D = (cur.number * 2) % 10000;

                if(arr[D] > cur.count + 1) {
                    arr[D] = cur.count + 1;
                    queue.add(new Node(D, cur.count + 1, cur.s + "D"));
                }

                int S = cur.number == 0 ? 9999 : cur.number - 1;

                if(arr[S] > cur.count + 1) {
                    arr[S] = cur.count + 1;
                    queue.add(new Node(S, cur.count + 1, cur.s + "S"));
                }

                int L = cur.number >= 1000 ? (int)((cur.number % Math.pow(10, (int)Math.log10(cur.number))) * 10 + cur.number / Math.pow(10, (int)Math.log10(cur.number))) : cur.number * 10;

                if(arr[L] > cur.count + 1) {
                    arr[L] = cur.count + 1;
                    queue.add(new Node(L, cur.count + 1, cur.s + "L"));
                }

                int R = cur.number >= 1000 ? (int)((int)(cur.number / 10) + (cur.number % 10) * Math.pow(10, (int)Math.log10(cur.number))) : cur.number % 10 * 1000 + cur.number / 10;

                if(arr[R] > cur.count + 1) {
                    arr[R] = cur.count + 1;
                    queue.add(new Node(R, cur.count + 1, cur.s + "R"));
                }
            }

            n--;
        }

        System.out.print(sb.toString());

    }

    static class Node {
        int number;
        int count;
        String s;

        public Node(int number, int count, String s){
            this.number = number;
            this.count = count;
            this.s = s;
        }
    }
}
