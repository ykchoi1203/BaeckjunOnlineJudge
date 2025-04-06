import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        depth = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[(int)Math.pow(2, depth) - 1];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=depth; i++) {
            map.put(i, new ArrayList<>());
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=map.size(); i++) {
            for(int j : map.get(i)) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }


    static int[] arr;
    static int depth;
    static int idx = 0;
    static Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    static void dfs(int cur) {
        if(cur != depth) dfs(cur + 1);
        map.get(cur).add(arr[idx++]);
        if(cur != depth) dfs(cur + 1);
    }

}
