import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(n);

        while(!pq.isEmpty()) {
            long num = pq.poll();

            long k = n;

            boolean isTrue = true;

            while(k >= 1) {
                if(k % 10 != 0 && num % (k % 10) != 0) {
                    isTrue = false;
                    break;
                }

                k /= 10;
            }

            if(isTrue) {
                answer = num;
                break;
            }

            num *= 10;
            for(int i=0; i<=9; i++) {
                pq.add(num + i);
            }
        }

        System.out.println(answer);

    }

    static long n;
    static long answer = 0;

}
