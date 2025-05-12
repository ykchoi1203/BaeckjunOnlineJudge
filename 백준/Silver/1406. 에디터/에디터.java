import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            left.add(s.charAt(i));
        }

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String str = br.readLine();

            switch(str.charAt(0)) {
                case 'L':
                    if(!left.isEmpty())
                        right.addFirst(left.pollLast());
                    break;
                case 'D':
                    if(!right.isEmpty())
                        left.addLast(right.poll());
                    break;
                case 'B':
                    if(!left.isEmpty()) {
                        left.pollLast();
                    }
                    break;
                case 'P':
                    left.addLast(str.charAt(2));
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!left.isEmpty()) {
            sb.append(left.poll());
        }

        while(!right.isEmpty()) {
            sb.append(right.poll());
        }

        System.out.println(sb.toString());

    }
}
