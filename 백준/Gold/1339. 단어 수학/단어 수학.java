import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for(int i=0; i<26; i++) {
            map.put((char)('A'+i), 0);
        }

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            int k = 1;
            for(int j=s.length()-1; j >= 0; j--) {
                map.put(s.charAt(j), map.get(s.charAt(j)) + k);
                k *= 10;
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for(char c : map.keySet()) {
            if(map.get(c) > 0) {
                pq.add(map.get(c));
            }
        }

        long answer = 0;
        int num = 9;
        while(!pq.isEmpty()) {
            answer += (long)pq.poll() * num--;
        }

        System.out.println(answer);

    }
}
