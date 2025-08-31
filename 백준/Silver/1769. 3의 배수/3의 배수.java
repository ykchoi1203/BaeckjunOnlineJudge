import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int cnt = 0;
        while(s.length() > 1) {
            int n = 0;
            cnt++;
            for(int i = 0; i < s.length(); i++) {
                n += s.charAt(i) - '0';
            }

            s = Integer.toString(n);
        }

        System.out.println(cnt);

        System.out.println(Integer.parseInt(s) % 3 == 0 ? "YES" : "NO");

    }
}