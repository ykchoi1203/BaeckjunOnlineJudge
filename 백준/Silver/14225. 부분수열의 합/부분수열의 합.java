import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Set<Integer> set = new TreeSet<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            Set<Integer> newSet = new TreeSet<>();
            newSet.add(arr[i]);
            for(int k : set) {
                newSet.add(arr[i] + k);
                newSet.add(k);
            }

            set = newSet;
        }

        int answer = 1;

        for(int i : set) {
            if(answer != i) {
                break;
            }
            answer++;
        }
        
        System.out.println(answer);
    }
}
