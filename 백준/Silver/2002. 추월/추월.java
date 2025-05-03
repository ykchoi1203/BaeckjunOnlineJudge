import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            map.put(s, i);
        }

        int cnt = 0;
        String[] arr = new String[n];

        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && map.get(arr[i]) < stack.peek()) {
                stack.pop();
                cnt++;
            }

            stack.push(map.get(arr[i]));
        }

        System.out.println(cnt);
    }
}
