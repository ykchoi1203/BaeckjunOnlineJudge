import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            list.add(new StringBuilder());
        }

        dfs(0, 0, n, false);

        for(StringBuilder sb : list) {
            System.out.println(sb.toString());
        }

    }

    static ArrayList<StringBuilder> list = new ArrayList<>();

    public static void dfs(int x, int y, int n, boolean isMid) {
        if(n == 3) {
            if(isMid) {
                for(int i = x; i < x + 3; i++)
                    list.get(i).append("   ");
                return;
            }
            list.get(x).append("***");
            list.get(x+1).append("* *");
            list.get(x+2).append("***");
            return;
        }

        int cnt = 0;
        for(int i = x; i < x + n; i += n / 3) {
            for(int j = y; j < y + n; j += n / 3) {
                if(cnt == 4) {
                    dfs(i, j, n/3, true);
                } else {
                    dfs(i, j, n/3, isMid);
                }
                cnt++;
            }
        }
    }
}
