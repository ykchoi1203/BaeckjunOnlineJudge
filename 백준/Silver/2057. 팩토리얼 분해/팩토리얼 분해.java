import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextLong();

        list = new ArrayList<Long>();

        list.add(1L);

        list.add(1L);

        int idx = 2;
        long factorial = 1;

        while(factorial * idx <= n && factorial >= 1) {
            factorial *= idx;
            list.add(factorial);
            idx++;
        }

        dfs(0, 0);

        System.out.println(answer ? "YES" : "NO");
    }

    static long n;
    static ArrayList<Long> list;
    static boolean answer = false;

    public static void dfs(int idx, long sum) {
        for(int i = idx; i < list.size(); i++) {
            if(sum + list.get(i) < n) {
                dfs(i + 1, sum + list.get(i));
                if(answer) return;
            } else if(sum + list.get(i) == n) {
                answer = true;
                return;
            }
        }
    }
}
