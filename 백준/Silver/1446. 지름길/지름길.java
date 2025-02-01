import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int[] arr = new int[m + 1];

        for(int i=0; i<=m; i++) {
            arr[i] = i;
        }

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(b > m || a > m) continue;

            if(!map.containsKey(a)) {
                map.put(a, new HashMap<>());
            }

            Map<Integer, Integer> aMap = map.get(a);

            if(!aMap.containsKey(b)) {
                aMap.put(b, c);
            } else {
                aMap.put(b, Math.min(aMap.get(b), c));
            }
        }

        for(int i=0; i<=m; i++) {
            if(i > 0)
                arr[i] = Math.min(arr[i], arr[i-1] + 1);
            if(map.containsKey(i)) {
                for(int next : map.get(i).keySet()) {
                    arr[next] = Math.min(Math.min(arr[next], arr[next-1] + 1), arr[i] + map.get(i).get(next));
                }
            }
        }

        System.out.println(arr[m]);
    }
}
