import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        String b = sc.nextLine();

        String temp;

        if(a.length() < b.length()) {
            temp = b;
            b = a;
            a = temp;
        }

        int answer = a.length() + b.length();

        String a1 = "0".repeat(b.length()) + a + "0".repeat(b.length());

        for(int i=1; i < a.length() + b.length(); i++) {
            boolean isTrue = true;
            for(int j=0; j < b.length(); j++) {
                if((a1.charAt(i + j) - '0') + (b.charAt(j) - '0') == 4) {
                    isTrue = false;
                    break;
                }
            }

            if(isTrue) {
                int left = Math.min(i, b.length());
                int right = Math.max(i + b.length(), a.length() + b.length());

                if (answer <= right - left) break;
                answer = right - left;
            }
        }

        System.out.println(answer);
    }
}
