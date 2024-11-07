import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String numbers = sc.nextLine();
        
        boolean isMinus = false;
        StringBuilder sb = new StringBuilder();
        
        int answer = 0;      
        
        for(int i=0; i<numbers.length(); i++) {
            if(numbers.charAt(i) == '-' || numbers.charAt(i) == '+') {
                if(sb.length() != 0) {
                    if(isMinus) {
                        answer -= Integer.parseInt(sb.toString());
                    } else {
                        answer += Integer.parseInt(sb.toString());
                    }
                }
                
                if(numbers.charAt(i) == '-') {
                    isMinus = true;
                }  
                
                sb = new StringBuilder();
            } else {
                sb.append(numbers.charAt(i));
            }
        }
        
        if(sb.length() != 0) {
            if(isMinus) {
                answer -= Integer.parseInt(sb.toString());
            } else {
                answer += Integer.parseInt(sb.toString());
            }
        }
        
        System.out.println(answer);
        
    }
}