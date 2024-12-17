import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        while(n > 0) {
            int k = Integer.parseInt(br.readLine());

            int[][] arr = new int[k][2];

            for(int i = 0; i < k; i++) {
                String[] s = br.readLine().split(" ");
                arr[i][0] = Integer.parseInt(s[0]);
                arr[i][1] = Integer.parseInt(s[1]);
            }

            Arrays.sort(arr, (a, b) -> a[0] - b[0]);

            int answer = 1;
            int score = arr[0][1];
            for(int i=1; i<k; i++) {
                if(arr[i][1] < score) {
                    answer++;
                    score = arr[i][1];
                }
            }

            System.out.println(answer);

            n--;
        }
    }
}
