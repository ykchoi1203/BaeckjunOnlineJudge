import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();

        for(int i=0; i<k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int m = sc.nextInt()-1;
            int n = sc.nextInt()-1;
            int answer = -1;

            for(int j=m; j<x*y; j+=x) {
                if(j % y == n) {
                    answer = j + 1;
                    break;
                }
            }
            
            System.out.println(answer);
        }
    }
}
