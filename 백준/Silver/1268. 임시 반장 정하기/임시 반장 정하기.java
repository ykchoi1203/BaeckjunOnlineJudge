import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<ArrayList<Set<Integer>>> list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][5];

        for(int i = 0; i < 5; i++) {
            list.add(new ArrayList<>());
            for(int j = 0; j < 10; j++) {
                list.get(i).add(new HashSet<>());
            }
        }

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<5; j++) {
                int room = Integer.parseInt(st.nextToken());
                list.get(j).get(room - 1).add(i);
                arr[i-1][j] = room - 1;
            }
        }

        int max = 0;
        int idx = 1;

        for(int i = 1; i <=n; i++) {
            Set<Integer> set = new HashSet<>();

            for(int j = 0; j < 5; j++) {
                set.addAll(list.get(j).get(arr[i-1][j]));
            }

            if(set.size() > max) {
                max = set.size();
                idx = i;
            }
        }

        System.out.println(idx);
        
    }
}