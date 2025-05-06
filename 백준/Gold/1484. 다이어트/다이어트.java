import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int cur = 1;
        int last = 1;

        TreeSet<Integer> set = new TreeSet<>();

        while(true) {
            if(last == cur + 1 && last * last - cur * cur > n) break;

            if(last * last - cur * cur == n) {
                set.add(last);
                cur++;
                last = cur + 1;
            } else if(last * last - cur * cur < n ) {
                last++;
            } else {
                cur++;
                last = cur + 1;
            }
        }

        if(set.isEmpty()) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();

        for(int i : set) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}
