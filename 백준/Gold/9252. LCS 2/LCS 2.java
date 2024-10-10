import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        int[][] arr = new int[s1.length() + 1][s2.length() + 1];

        for(int i=1; i<=s1.length(); i++) {
            for(int j=1; j<=s2.length(); j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    arr[i][j] = arr[i-1][j-1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i][j-1], arr[i-1][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        int i=s1.length(), j = s2.length();

        while(i > 0 && j > 0) {

            if(s1.charAt(i-1) == s2.charAt(j-1)) {
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            } else if(arr[i-1][j] == arr[i][j]) {
                i--;
            } else if(arr[i][j-1] == arr[i][j]){
                j--;
            }
        }
    
        System.out.println(sb.length());
        System.out.println(sb.reverse().toString());

    }
}
