import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();

        StringBuilder reverse = new StringBuilder(s);

        s = reverse.reverse().toString();

        String answer = "z".repeat(s.length());

        for(int i = 0; i < s.length(); i++) {
            for(int j = i + 1; j < s.length() -1; j++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(s, j + 1, s.length()).append(s, i + 1, j + 1).append(s, 0, i + 1);

                    answer = answer.compareTo(sb.toString()) < 0 ? answer : sb.toString();
            }
        }

        System.out.println(answer);
        
    }
}