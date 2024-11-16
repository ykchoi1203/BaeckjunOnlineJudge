import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int answer = 0;

        String s = br.readLine();

        String io = "IO".repeat(Math.max(0, n)) + "I";

        boolean isTrue = false;

        for(int i=0; i<m ; i++) {
            if(!isTrue && i + io.length() - 1 < m) {
                boolean checkNew = true;
                for(int j=0; j<io.length(); j++) {
                    if(io.charAt(j) != s.charAt(i + j)) {
                        if(s.charAt(i + j) == 'I')
                            i += j-1;
                        else i += j;
                        checkNew = false;
                        break;
                    }
                }

                if(checkNew) {
                    isTrue = true;
                    i += io.length()-1;
                    answer++;
                }
            } else if(isTrue && i + 1 < m) {
                if(s.charAt(i) == 'O' && s.charAt(i + 1) == 'I') {
                    answer++;
                    i++;
                } else {
                    isTrue = false;
                    i--;
                }
            }
        }

        System.out.println(answer);

    }
}
