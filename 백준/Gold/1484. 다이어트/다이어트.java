import java.util.*;

public class Main {
    public static void main(String[] args) {
               Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int cur = 1;
        int last = 1;
        
        StringBuilder sb = new StringBuilder();
        
        while (last != cur + 1 || last * last - cur * cur <= n) {
            if (last * last - cur * cur == n) {
                sb.append(last).append("\n");
                cur++;
                last = cur + 1;
            } else if (last * last - cur * cur < n) {
                last++;
            } else {
                cur++;
                last = cur + 1;
            }
        }
        
        if(sb.length() == 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(sb);
    }
}
