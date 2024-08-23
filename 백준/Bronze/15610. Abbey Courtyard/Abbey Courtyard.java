import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long n = sc.nextLong();
        
        double len = Math.sqrt(n);
        
        System.out.println(len * 4);
    }
}