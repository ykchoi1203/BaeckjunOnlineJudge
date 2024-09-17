import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        Map<Integer, Integer> round = new HashMap<>();
        int sum = 0;
        for(int key : map.keySet()) {
            round.put(key, sum);
            sum++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int num : arr) {
            sb.append(round.get(num)).append(" ");
        }
        
        System.out.print(sb.toString());
        
    }
}