import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtrack(0);

        System.out.println(answer);

    }

    static int[][] arr;
    static int answer = Integer.MAX_VALUE;
    static Set<Integer> set = new HashSet<>();

    static void backtrack(int start) {
        if(set.size() == arr.length / 2) {
            int sum1 = 0;
            int sum2 = 0;

            for(int i : set) {
                for(int j : set) {
                    if(i != j) {
                        sum1 += arr[i][j];
                    }
                }
            }

            Set<Integer> others = new HashSet<>();
            for(int i = 0; i < arr.length; i++) {
                if(!set.contains(i)) {
                    others.add(i);
                }
            }

            for(int i : others) {
                for(int j : others) {
                    if(i != j) {
                        sum2 += arr[i][j];
                    }
                }
            }

            answer = Math.min(answer, Math.abs(sum1 - sum2));
            return;
        }

        if(start == arr.length) {
            return;
        }

        for(int i=start; i<arr.length; i++) {
            set.add(i);
            backtrack(i + 1);
            set.remove(i);
        }
    }
}
