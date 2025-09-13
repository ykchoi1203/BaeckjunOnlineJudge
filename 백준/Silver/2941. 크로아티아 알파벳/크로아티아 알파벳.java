import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s = sc.nextLine();
        
        System.out.println(s.replaceAll("c=", " a ")
                           .replaceAll("c-", " a ")
                           .replaceAll("dz=", " a ")
                           .replaceAll("d-", " a ")
                           .replaceAll("lj", " a ")
                           .replaceAll("nj", " a ")
                           .replaceAll("s=", " s ")
                           .replaceAll("z=", " z ")
                           .replaceAll(" ", "").length());
    }
}