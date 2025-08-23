import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s = sc.nextLine();
        
        int cnt0 = 0;
        int cnt1 = 0;
        
        for(int i = 0; i < s.length();) {
            if(s.charAt(i) == '1') {
                cnt1++;
                while(i < s.length() && s.charAt(i) == '1') {
                    i++;
                }
            } else {
                cnt0++;
                while(i < s.length() && s.charAt(i) == '0') {
                    i++;
                }
            }
        }
        
        System.out.println(Math.min(cnt0, cnt1));
        
    }
}