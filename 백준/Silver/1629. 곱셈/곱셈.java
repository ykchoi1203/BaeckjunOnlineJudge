import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();
        c = sc.nextLong();

        System.out.println(pow(a, b));
    }
    
    public static long c;
    
    public static long pow(long a, long e) {
		if(e == 1) {
			return a % c;
		}

		long temp = pow(a, e / 2);

		if(e % 2 == 1) {
			return ((temp * temp) % c) * a % c;
		}
        
		return (temp * temp) % c;
	}
}
