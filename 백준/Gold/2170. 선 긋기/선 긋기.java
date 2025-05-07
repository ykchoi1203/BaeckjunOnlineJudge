import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        int start = arr[0][0];
        int end = arr[0][0];

        int answer = 0;

        for(int i = 0; i < n; i++) {
            boolean isErase = false;
            while(!pq.isEmpty() && pq.peek()[1] < arr[i][0]) {
                end = Math.max(pq.poll()[1], end);
                isErase = true;
            }

            if(isErase) {
                answer += end - start;
                start = arr[i][0];
                end = arr[i][0];
            }

            pq.offer(arr[i]);

        }

        if(!pq.isEmpty()) {
            answer += pq.poll()[1] - start;
        }

        System.out.println(answer);
    }
}
