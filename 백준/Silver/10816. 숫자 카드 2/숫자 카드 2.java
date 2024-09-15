import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        String[] numbers = br.readLine().split(" ");
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(String number : numbers) {
            map.put(Integer.parseInt(number), map.getOrDefault(Integer.parseInt(number), 0) + 1);
        }
        
        int m = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        numbers = br.readLine().split(" ");
        
        for(String number : numbers) {
            sb.append(map.containsKey(Integer.parseInt(number)) ? map.get(Integer.parseInt(number)) : 0).append(" ");
        }
        
        System.out.println(sb.toString());
        
    }
}
