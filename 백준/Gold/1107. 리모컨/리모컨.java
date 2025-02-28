import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int k = sc.nextInt();

        boolean[] arr = new boolean[10];

        for(int i=0; i<k; i++) {
            arr[sc.nextInt()] = true;
        }

        int[] dp = new int[1000001];

        Arrays.fill(dp, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        q2.add(100);

        for(int i = 0; i < 10; i++) {
            if(!arr[i] && dp[i] != 0) {
                q.add(i);
                q2.add(i);
                dp[i] = 1;
            }
        }

        if(n == 100) {
            System.out.println(0);
            return;
        }

        while(!q.isEmpty()) {
            int cur = q.poll();

            if(cur != 0) {
                cur *= 10;
                for(int i=0; i<10; i++) {
                    if(!arr[i] && cur + i <= 1000000 && dp[cur + i] > dp[cur / 10] + 1) {
                        dp[cur + i] = dp[cur / 10] + 1;
                        q.add(cur + i);
                        q2.add(cur + i);
                    }
                }
            }

        }

        dp[100] = 0;

        while(!q2.isEmpty()) {
            int cur = q2.poll();

            if(cur - 1 >= 0 && dp[cur-1] > dp[cur] + 1) {
                dp[cur-1] = dp[cur] + 1;
                q2.add(cur-1);
            }

            if(cur + 1 <= 1000000 && dp[cur + 1] > dp[cur] + 1) {
                dp[cur+1] = dp[cur] + 1;
                q2.add(cur+1);
            }
        }

        System.out.println(dp[n]);
    }
}
