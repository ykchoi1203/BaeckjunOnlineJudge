import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int m = Integer.parseInt(br.readLine());
        
        boolean[] x = new boolean[21];
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++) {
            String[] arr = br.readLine().split(" ");
            
            switch(arr[0]) {
                case "add":
                    x[Integer.parseInt(arr[1])] = true;
                    break;
                case "check":
                    sb.append(x[Integer.parseInt(arr[1])] ? 1 : 0).append("\n");
                    break;
                case "remove":
                    x[Integer.parseInt(arr[1])] = false;
                    break;
                case "toggle":
                    x[Integer.parseInt(arr[1])] = !x[Integer.parseInt(arr[1])];
                    break;
                case "all":
                    Arrays.fill(x, true);
                    break;
                case "empty":
                    Arrays.fill(x, false);
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}