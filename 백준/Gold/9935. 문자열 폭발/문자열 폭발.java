import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s = sc.nextLine();
        String bomb = sc.nextLine();
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            stack.add(s.charAt(i));
            
            if(stack.size() < bomb.length()) {
                continue;    
            }
            
            if(stack.peek() == bomb.charAt(bomb.length() - 1)) {
                Stack<Character> newStack = new Stack<>();
                int idx = bomb.length() - 1;
                while(idx >= 0 && stack.peek() == bomb.charAt(idx)) {
                    newStack.add(stack.pop());
                    idx--;
                }
                
                if(idx != -1) {
                    while(!newStack.isEmpty()) {
                        stack.add(newStack.pop());
                    }
                }
            }
        }
        
        if(stack.isEmpty()) {
            System.out.println("FRULA");
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        System.out.println(sb.reverse().toString());
 
    }
}