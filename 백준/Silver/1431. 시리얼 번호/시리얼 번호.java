import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        TreeMap<Integer, TreeMap<Integer, TreeSet<String>>> map = new TreeMap<>();

        for(int i=0; i<n; i++) {
            String s = br.readLine();

            if(!map.containsKey(s.length())) {
                map.put(s.length(), new TreeMap<>());
            }

            int sum = 0;

            for(int j = 0; j < s.length(); j++) {
                int k = s.charAt(j) - '0';

                if(k >= 1 && k <= 9) sum += k;
            }

            if(!map.get(s.length()).containsKey(sum)) {
                map.get(s.length()).put(sum, new TreeSet<>());
            }

            map.get(s.length()).get(sum).add(s);
        }

        StringBuilder sb = new StringBuilder();


        for(int num : map.keySet()) {
            for(int nextNum : map.get(num).keySet()) {
                for(String s : map.get(num).get(nextNum)) {
                    sb.append(s);
                    if(n > 1) {
                        sb.append("\n");
                        n--;
                    }

                }
            }
        }

        System.out.println(sb.toString());
    }
}