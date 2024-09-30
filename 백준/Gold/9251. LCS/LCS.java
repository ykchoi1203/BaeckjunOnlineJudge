import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int[][] arr = new int[s2.length()][s1.length()];

        for(int i=0; i<s2.length(); i++) {
            int min = 0;
            for(int j=0; j<s1.length(); j++) {
                if(s1.charAt(j) == s2.charAt(i)) {
                    if(i != 0)
                        arr[i][j] = Math.max(arr[i-1][j], min + 1);
                    else
                        arr[i][j] = 1;
                } else {
                    if(i != 0)
                        arr[i][j] = arr[i-1][j];
                }

                if(i > 0) min = Math.max(min, arr[i-1][j]);
            }
        }

        int max = 0;
        for(int i=0; i<s1.length(); i++) {
            max = Math.max(max, arr[s2.length()-1][i]);
        }

        System.out.println(max);
    }
}
