import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Jewel[] jewels = new Jewel[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            jewels[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        Arrays.sort(jewels);
        
        long answer = 0;

        int[] bags = new int[k];

        for(int i=0; i<k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);
        
        int idx = 0;
        
        PriorityQueue<Jewel> pq = new PriorityQueue<>((a, b) -> b.value - a.value);
        
        for(int i=0; i < k; i++) {
            while(idx < n && bags[i] >= jewels[idx].weight) {
                pq.add(jewels[idx]);
                idx++;
            }
            
            if(!pq.isEmpty()) {
                answer += pq.poll().value;
            }
        }

        System.out.println(answer);

    }

    public static class Jewel implements Comparable<Jewel> {
        int weight;
        int value;

        public Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Jewel j) {
            if(weight != j.weight) {
                return weight - j.weight;
            }

            return j.value - value;
        }
    }
}
