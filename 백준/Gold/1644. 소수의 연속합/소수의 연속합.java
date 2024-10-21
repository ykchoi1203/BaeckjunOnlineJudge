import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(2);
        
        for(int i=3; i <=n; i += 2) {
            if(isTrue(i)) {
                list.add(i);
            }
        }
        
        int start = 0;
        int end = 0;
        int sum = 0;
        int answer = 0;
        
        while(start < list.size()) {
            sum += list.get(end);

            if(sum > n) {
                start++;
                end = start;
                sum = 0;
            } else if(sum == n) {
                answer++;
                start++;
                end = start;
                sum = 0;
            } else {
                end++;
                if(end >= list.size()) {
                    start++;
                    end = start;
                    sum = 0;
                }
            }
        }    
        
        System.out.println(answer);

    }
    
    public static boolean isTrue(int n) {
        if(n % 2 == 0) return false;
        
        for(int i=3; i<= Math.sqrt(n); i+=2) {
            if(n % i == 0) return false;
        }
        
        return true;
    }

}
