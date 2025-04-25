import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] weight = new int[m];

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            Set<Integer> newSet =  new HashSet<>();
            for (int k : set) {
                newSet.add(Math.abs(k - arr[i]));
                newSet.add(Math.abs(k + arr[i]));
                newSet.add(k);
            }

            newSet.add(arr[i]);
            set = newSet;
        }

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
            if(set.contains(weight[i])) {
                sb.append("Y ");
            } else {
                sb.append("N ");
            }
        }

        System.out.println(sb.toString());

    }
}
