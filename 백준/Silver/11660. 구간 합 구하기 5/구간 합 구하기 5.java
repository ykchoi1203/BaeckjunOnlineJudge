import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");

        long[][] arr = new long[Integer.parseInt(NM[0])][Integer.parseInt(NM[0])];

        for(int i=0; i<arr.length; i++) {
            String[] cur = br.readLine().split(" ");
            long sum = 0;
            for(int j=0; j<cur.length; j++) {
                sum += Integer.parseInt(cur[j]);
                if(i == 0) {
                    arr[i][j] = sum;
                } else {
                    arr[i][j] = arr[i-1][j] + sum;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<Integer.parseInt(NM[1]); i++) {
            String[] idxs = br.readLine().split(" ");

            long sum = arr[Integer.parseInt(idxs[2])-1][Integer.parseInt(idxs[3])-1]
                    - (Integer.parseInt(idxs[1]) == 1 ? 0 : arr[Integer.parseInt(idxs[2])-1][Integer.parseInt(idxs[1])-2])
                    - (Integer.parseInt(idxs[0]) == 1 ? 0 : arr[Integer.parseInt(idxs[0])-2][Integer.parseInt(idxs[3])-1])
                    + (Integer.parseInt(idxs[0]) != 1 && Integer.parseInt(idxs[1]) != 1 ? arr[Integer.parseInt(idxs[0])-2][Integer.parseInt(idxs[1])-2] : 0);
            sb.append(sum).append("\n");
        }

        System.out.println(sb.toString());
        
    }
}