import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        
        s =s.replaceAll("XXXX", "AAAA").replaceAll("XX", "BB"); 
        
        System.out.println(s.contains("X") ? -1 : s);
        
    }
}
