import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[Integer.parseInt(st.nextToken())];
        start = Integer.parseInt(st.nextToken());
        max = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        TreeSet<Integer> set = new TreeSet<>();
        set.add(start);

        for(int i=0; i<arr.length; i++) {
            TreeSet<Integer> newSet = new TreeSet<>();

            for(int k : set) {
                if(k + arr[i] <= max) newSet.add(k + arr[i]);
                if(k - arr[i] >= 0) newSet.add(k - arr[i]);
            }

            set = newSet;
        }

        System.out.println(set.isEmpty() ? -1 : set.last());

    }

    static int[] arr;
    static int start;
    static int max;

}
