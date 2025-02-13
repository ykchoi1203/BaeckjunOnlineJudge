import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n * 2 + 1];
        int[] clipBoard = new int[n * 2 + 1];

        Arrays.fill(arr, Integer.MAX_VALUE);
        Arrays.fill(clipBoard, Integer.MAX_VALUE);

        arr[1] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        queue.add(new int[] {1, 0, 0});

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            if(arr[cur[0]] == Integer.MAX_VALUE) {
                arr[cur[0]] = cur[1];
            }

            if(cur[0] + cur[2] <= n * 2) {
                if (arr[cur[0] + cur[2]] == Integer.MAX_VALUE || arr[cur[0] + cur[2]] + 1 < arr[cur[0] + cur[2]])
                    queue.add(new int[] {cur[0] + cur[2], cur[1] + 1, cur[2]});
                if(clipBoard[cur[0]] == Integer.MAX_VALUE || cur[1] + 1 < clipBoard[cur[0]]) {
                    queue.add(new int[] {cur[0], cur[1] + 1, cur[0]});
                    clipBoard[cur[0]] = cur[1] + 1;
                }
            }

            if(cur[0] > 0 && (arr[cur[0] - 1] == Integer.MAX_VALUE || arr[cur[0] - 1] + 1 < arr[cur[0] - 1]))
                queue.add(new int[] {cur[0] - 1, cur[1] + 1, cur[2]});

        }

        System.out.println(arr[n]);

    }
}
