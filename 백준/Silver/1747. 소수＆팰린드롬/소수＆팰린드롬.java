import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        if(n == 1 || n == 2) {
            System.out.println(2);
            return;
        }

        if(n % 2 == 0) {
            n++;
        }

        while(true) {
            if(isPrime(n) && isPalindrome(n)) {
                System.out.println(n);
                return;
            }
            n+=2;
        }

    }

    public static boolean isPrime(int n) {
        if(n == 2) return true;
        if(n % 2 == 0) return false;

        for(int i=3; i <= Math.sqrt(n); i+=2){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int n) {
        String s = String.valueOf(n);
        for(int i=0; i <= s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
