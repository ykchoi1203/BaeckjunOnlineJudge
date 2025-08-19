import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Arrays.stream(s.split("")).sorted(Comparator.reverseOrder()).forEach(System.out::print);
    }
}
