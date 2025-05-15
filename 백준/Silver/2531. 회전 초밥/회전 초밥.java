import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();

        int[] arr = new int[n + k];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i = n; i < n + k; i++) {
            arr[i] = arr[i - n];
        }

        for(int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int max = map.size();

        int answer = max;

        if(!map.containsKey(c)) answer++;

        for(int i = k; i < n + k; i++) {
            map.put(arr[i-k], map.get(arr[i-k]) - 1);
            if(map.get(arr[i-k]) == 0) {
                max--;
            }

            if(map.containsKey(arr[i])) {
                if(map.get(arr[i]) == 0) max++;
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
                max++;
            }

            if(!map.containsKey(c) || map.get(c) == 0) {
                answer = Math.max(answer, max + 1);
            } else {
                answer = Math.max(answer, max);
            }
        }

        System.out.println(answer);

    }
}
