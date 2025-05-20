import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s = sc.nextLine();
        
        int[] arr = new int[26];
        
        for(int i=0; i<s.length(); i++) {
            arr[s.charAt(i) - 'A']++;
        }
        
        int idx = -1;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < 26; i++) {
            if(arr[i] == 0) continue;
            if(idx != -1 && arr[i] % 2 == 1) {
                System.out.println("I'm Sorry Hansoo");
                return;
            } 
            
            if(arr[i] % 2 == 1) {
                idx = i;
                arr[i]--;
            }

            for(int j = 0; j < arr[i] / 2; j++)
                sb.append((char)('A' + i));
        }
        
        if(idx != -1)
            sb.append((char)('A' + idx));
        
        for(int i = 25; i >= 0; i--) {
            if(arr[i] != 0 && arr[i] % 2 == 0) {
                for(int j = 0; j < arr[i] / 2; j++)
                    sb.append((char)('A' + i));
            }
        }
        
        System.out.println(sb.toString());
        
    }
}