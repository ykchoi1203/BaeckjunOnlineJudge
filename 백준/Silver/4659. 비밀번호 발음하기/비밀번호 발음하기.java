import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        StringBuilder sb = new StringBuilder();
        while(!(s = br.readLine()).equals("end")) {
            char lastChar = '-';
            int sameCnt = 0;
            int isOccCnt = 0;
            boolean hasVal = false;

            boolean isTrue = true;
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) == lastChar) {
                    sameCnt++;
                    if(sameCnt == 2 && lastChar != 'e' && lastChar != 'o') {
                        isTrue = false;
                        break;
                    }
                } else {
                    sameCnt = 1;
                }

                if(set.contains(s.charAt(i)) && set.contains(lastChar)) {
                    isOccCnt++;

                    if(isOccCnt == 3) {
                        isTrue = false;
                        break;
                    }

                    hasVal = true;

                } else if(!set.contains(s.charAt(i)) && !set.contains(lastChar)) {
                    isOccCnt++;
                    if(isOccCnt == 3) {
                        isTrue = false;
                        break;
                    }
                } else {
                    isOccCnt = 1;
                    hasVal = true;
                }

                lastChar = s.charAt(i);
            }

            if(hasVal && isTrue) {
                sb.append("<").append(s).append("> is acceptable.\n");
            } else {
                sb.append("<").append(s).append("> is not acceptable.\n");
            }
        }

        System.out.println(sb);
    }
}
