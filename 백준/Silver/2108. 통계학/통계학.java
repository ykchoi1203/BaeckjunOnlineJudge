import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long sum = 0;
        PriorityQueue<Integer> small = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> large = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int maxCnt = 0;
        int maxIdx = 4001;
        int maxIdx2 = 4001;

        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());
            min = Math.min(min, num);
            max = Math.max(max, num);
            sum += num;
            if(!map.containsKey(num)) {
                map.put(num, 0);
            }

            map.put(num, map.get(num) + 1);
            if(map.get(num) > maxCnt) {
                maxCnt = map.get(num);
                maxIdx = num;
                maxIdx2 = 4001;
            } else if(map.get(num) == maxCnt) {
                if(maxIdx > num) {
                    maxIdx2 = maxIdx;
                    maxIdx = num;
                } else if(maxIdx2 > num) {
                    maxIdx2 = num;
                }
            }

            if(small.isEmpty()) {
                small.add(num);
            } else {
                if(i % 2 != 0) {
                    if(small.peek() >= num) {
                        large.offer(small.poll());
                        small.offer(num);
                    } else {
                        large.offer(num);
                    }
                } else {
                    if(large.peek() <= num) {
                        large.offer(num);
                        small.offer(large.poll());
                    } else {
                        large.offer(num);
                        small.offer(large.poll());
                    }
                }
            }

        }

        System.out.println(Math.round((float) sum / n));
        System.out.println(small.peek());
        System.out.println(maxIdx2 == 4001 ? maxIdx : maxIdx2);
        System.out.println(max - min);

    }
}
