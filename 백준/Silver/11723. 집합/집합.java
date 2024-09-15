import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int m = Integer.parseInt(br.readLine());
        
        Set<Integer> setAll = new HashSet<>();
        
        for(int i=1; i<=20; i++) {
            setAll.add(i);
        }
        
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++) {
            String[] arr = br.readLine().split(" ");
            
            switch(arr[0]) {
                case "add":
                    set.add(Integer.parseInt(arr[1]));
                    break;
                case "check":
                    sb.append(set.contains(Integer.parseInt(arr[1])) ? 1 : 0).append("\n");
                    break;
                case "remove":
                    set.remove(Integer.parseInt(arr[1]));
                    break;
                case "toggle":
                    if(set.contains(Integer.parseInt(arr[1]))) {
                        set.remove(Integer.parseInt(arr[1]));
                    } else {
                        set.add(Integer.parseInt(arr[1]));
                    }
                    break;
                case "all":
                    set.addAll(setAll);
                    break;
                case "empty":
                    set = new HashSet<>();
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}