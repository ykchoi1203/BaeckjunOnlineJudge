import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            q.addLast(i);
        }

        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()) {
            int idx = q.pollFirst();
            sb.append(idx + 1).append(" ");

            if(q.isEmpty()) break;

            if(arr[idx] > 0) {
                for(int i = 0; i < arr[idx] - 1; i++) {
                    q.addLast(q.pollFirst());
                }
            } else {
                for(int i = 0; i < -arr[idx]; i++) {
                    q.addFirst(q.pollLast());
                }
            }
        }

        System.out.println(sb);

    }
}