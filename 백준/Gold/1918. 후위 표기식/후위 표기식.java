import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(c >= 'A' && c <= 'Z') {
                sb.append(c);
            } else if(c == '*' || c == '/') {
                if(!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
                    sb.append(stack.pop());
                }
                stack.push(c);
            } else if(c == '+' || c == '-') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }

                stack.push(c);
            } else if(c == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }

                if(!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            } else if(c == '(') {
                stack.push(c);
            }

        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }
}

// A-(B+C*(D+E)/F+G)*H-I+J

