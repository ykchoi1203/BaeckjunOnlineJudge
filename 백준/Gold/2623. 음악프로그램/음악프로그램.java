import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int i=0; i<=n; i++) {
            map.put(i, new HashSet<>());
        }


        for(int i=0; i<m; i++) {
            String[] numbers = br.readLine().split(" ");

            for(int j=2; j<numbers.length; j++) {
                if(map.get(Integer.parseInt(numbers[j-1])).add(Integer.parseInt(numbers[j])))
                    arr[Integer.parseInt(numbers[j])]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;
        
        for(int i=1; i<=n; i++) {
            if(arr[i] == 0) {
                queue.add(i);
                cnt++;
            }
        }

        StringBuilder sb = new StringBuilder();
        
        while(!queue.isEmpty()) {
            int curIdx = queue.poll();
            sb.append(curIdx).append("\n");
            for(int nextIdx : map.get(curIdx)) {
                arr[nextIdx]--;
                if(arr[nextIdx] == 0) {
                    queue.add(nextIdx);
                    cnt++;
                }
            }
        }

        System.out.println(cnt < n ? "0" : sb.toString());

    }

}
