import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long a = 0;
        long b = 1;

        if(n == 0) {
            System.out.println(0);
            return;
        } else if(n == 1) {
            System.out.println(1);
            return;
        }

        int cnt = 1;

        String aS = "0";
        String bS = "1";

        while(cnt < n) {
            Stack<Integer> stack = new Stack<>();

            int isBigTen = 0;
            int len = bS.length() - aS.length();
            for(int i = aS.length() - 1; i >= 0; i--) {
                int cur = (aS.charAt(i) - '0') + (bS.charAt(i + len) - '0') + isBigTen;
                if(cur >= 10) {
                    stack.push(cur - 10);
                    isBigTen = 1;
                } else {
                    isBigTen = 0;
                    stack.push(cur);
                }
            }

            for(int i = bS.length() - aS.length() - 1; i >= 0; i--) {
                int cur = (bS.charAt(i) - '0') + isBigTen;
                if(cur >= 10) {
                    stack.push(cur - 10);
                    isBigTen = 1;
                } else {
                    isBigTen = 0;
                    stack.push(cur);
                }
            }

            if(bS.length() == aS.length() && isBigTen == 1) {
                stack.push(1);
            }

            StringBuilder stringBuilder = new StringBuilder();

            while(!stack.isEmpty()) {
                stringBuilder.append(stack.pop());
            }

            aS = bS;
            bS = stringBuilder.toString();
            cnt++;
        }

        System.out.println(bS);

    }
}