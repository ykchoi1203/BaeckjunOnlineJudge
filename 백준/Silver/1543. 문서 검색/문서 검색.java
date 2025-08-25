import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        
        int len = s1.length();
        
        s1 = s1.replaceAll(s2, "");
        
        System.out.println((len - s1.length()) / s2.length());
        
    }
}