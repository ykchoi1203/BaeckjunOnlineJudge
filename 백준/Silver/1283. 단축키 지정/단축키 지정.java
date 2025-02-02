import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Set<Character> set = new HashSet<>();

        for(int i=0; i<n; i++) {
            String[] s = br.readLine().split(" ");

            boolean isTrue = false;
            for(int j=0; j<s.length; j++) {
                char c = s[j].charAt(0);

                if(c > 'Z' || c < 'A') {
                    c += 'A' - 'a';
                }

                if(!set.contains(c)) {
                    set.add(c);
                    for(int k=0; k<s.length; k++) {
                        if(k == j) {
                            System.out.print("[" + s[k].charAt(0) + "]" + s[k].substring(1) + " ");
                        } else {
                            System.out.print(s[k] + " ");
                        }
                    }
                    System.out.println();
                    isTrue = true;
                    break;
                }
            }

            if(isTrue) continue;

            loop:
            for(int j = 0; j < s.length; j++) {
                for(int k=0; k<s[j].length(); k++) {
                    char c = s[j].charAt(k);

                    if(c > 'Z' || c < 'A') {
                        c += 'A' - 'a';
                    }

                    if(!set.contains(c)) {
                        set.add(c);
                        for(int l=0; l<s.length; l++) {
                            if(j == l) {
                                for(int m = 0; m < s[l].length(); m++) {
                                    if(m == k) {
                                        System.out.print("[" + s[l].charAt(m) + "]");
                                    } else {
                                        System.out.print(s[l].charAt(m));
                                    }
                                }
                                System.out.print(" ");
                            } else {
                                System.out.print(s[l] + " ");
                            }
                        }
                        System.out.println();
                        isTrue = true;
                        break loop;
                    }
                }
            }

            if(!isTrue) {
                for(String str : s) {
                    System.out.print(str + " ");
                }
                System.out.println();
            }

        }

    }
}
