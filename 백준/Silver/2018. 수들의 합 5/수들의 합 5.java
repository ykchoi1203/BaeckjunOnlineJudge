import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int cnt = 0;

        for(int i = 1; i <= n; i++) {
            int sum = i;
            int j = i + 1;
            while(sum <= n) {
                if(sum == n) {
                    cnt++;
                    break;
                }
                sum += j;
                j++;
            }
        }

        System.out.println(cnt);

    }
}
