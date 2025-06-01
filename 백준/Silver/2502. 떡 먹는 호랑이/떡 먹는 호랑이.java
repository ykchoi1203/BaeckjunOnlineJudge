import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int dayOne = 1;
        int dayTwo = 1;

        while(true) {
            int days = 2;

            int k = dayOne;
            int l = dayTwo;

            while(days < n && l <= m) {
                int temp = k;
                k = l;
                l += temp;
                days++;
            }

            if(days == n && l == m) {
                System.out.println(dayOne);
                System.out.println(dayTwo);
                return;
            }

            if(days < n) {
                dayOne++;
                dayTwo = dayOne;
            } else {
                dayTwo++;
            }
        }
        
    }
}
