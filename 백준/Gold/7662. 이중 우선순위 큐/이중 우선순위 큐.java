import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        while(n > 0) {
            int k = Integer.parseInt(br.readLine());

            PriorityQueue<Long> asc = new PriorityQueue<>();
            PriorityQueue<Long> desc = new PriorityQueue<>(Comparator.reverseOrder());
            Map<Long, Integer> map = new HashMap<>();

            for(int i=0; i<k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String s = st.nextToken();
                long number = Long.parseLong(st.nextToken());
                if(s.equals("I")) {
                    asc.offer(number);
                    desc.offer(number);

                    if(map.containsKey(number)) {
                        map.put(number, map.get(number) + 1);
                    } else {
                        map.put(number, 1);
                    }

                } else {
                    if(number == 1) {
                        if(!desc.isEmpty()) {
                            if(map.get(desc.peek()) == 1) {
                                map.remove(desc.peek());
                            } else {
                                map.put(desc.peek(), map.get(desc.peek()) - 1);
                            }
                            desc.poll();


                        }
                    } else {
                        if(!asc.isEmpty()) {
                            if(map.get(asc.peek()) == 1) {
                                map.remove(asc.peek());
                            } else {
                                map.put(asc.peek(), map.get(asc.peek()) - 1);
                            }
                            asc.poll();
                        }
                    }

                    while(!desc.isEmpty() && !map.containsKey(desc.peek())) {
                        desc.poll();
                    }

                    while(!asc.isEmpty() && !map.containsKey(asc.peek())) {
                        asc.poll();
                    }
                }
            }

            while(!desc.isEmpty() && !map.containsKey(desc.peek())) {
                desc.poll();
            }

            while(!asc.isEmpty() && !map.containsKey(asc.peek())) {
                asc.poll();
            }

            if(asc.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(desc.peek() + " " + asc.peek());
            }

            n--;
        }
    }
}
