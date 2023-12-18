import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>();
        int num = Integer.parseInt(br.readLine());
        
         String[] numbers = br.readLine().split(" ");
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<numbers.length; i++) {
            if(map.containsKey(Integer.parseInt(numbers[i]))) {
                map.put(Integer.parseInt(numbers[i]), map.get(Integer.parseInt(numbers[i])) + 1);
            } else {
                map.put(Integer.parseInt(numbers[i]), 1);
            }
        }
        
        System.out.println(map.containsKey(n) ? map.get(n) : 0);
        
    }
}