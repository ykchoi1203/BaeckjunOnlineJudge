import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> index = new ArrayDeque<>();

        for(int i=0; i<n; i++) {
            while(!index.isEmpty() && arr[i] > arr[index.peek()]) {
                arr[index.poll()] = arr[i];
            }
            index.push(i);
        }

        while(!index.isEmpty()) {
            arr[index.poll()] = -1;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i < n; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb.toString());
    }
}
