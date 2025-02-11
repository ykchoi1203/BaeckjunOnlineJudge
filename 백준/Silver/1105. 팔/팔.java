import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        StringTokenizer st= new StringTokenizer(sc.nextLine());
        String l = st.nextToken();
        String r = st.nextToken();
        
        if(l.length() != r.length()) {
            System.out.println(0);
        } else {
            int cnt = 0;
            
            for(int i=0; i<l.length(); i++) {
                if(l.charAt(i) ==r.charAt(i)) {
                    if (l.charAt(i) == '8' && r.charAt(i) == '8') {
                        cnt++;
                    }
                } else break;
            }
            System.out.println(cnt);
        }
        
    }
}
