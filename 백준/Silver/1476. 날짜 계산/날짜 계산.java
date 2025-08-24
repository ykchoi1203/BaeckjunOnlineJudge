import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int e = sc.nextInt();
        int s = sc.nextInt();
        int m = sc.nextInt();
        
        int earth = 1;
        int sun = 1;
        int moon = 1;
        int answer = 1;
        
        while(earth != e || sun != s || moon != m) {
            earth = earth == 15 ? 1 : earth + 1;
            sun = sun == 28 ? 1 : sun + 1;
            moon = moon == 19 ? 1 : moon + 1;
            answer++;
        }
        
        System.out.println(answer);
            
    }
}