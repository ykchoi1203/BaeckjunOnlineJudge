import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i=9; i>=0; i--) {
            backTrack(i, i);
        }

        System.out.println(answer);
    }

    static int count = -1;
    static long answer = -1;
    static int[] number = new int[10];
    static int n;
    static boolean find = false;

    public static void backTrack(int startIdx, int idx) {
        if(idx == 10) {
            count++;

            if(count == n) {
                answer = 0;
                long num = 1;
                for(int i=9; i>=0; i--) {
                    answer += number[i] * num;
                    num *= 10;
                }
                find = true;

            }

            return;
        }

        if(find) return;

        for(int i=0; i<=9; i++) {
            number[idx] = i;
            if(idx != startIdx && number[idx-1] <= number[idx]) {
                number[idx] = 0;
                return;
            }
            backTrack(startIdx, idx + 1);
            if(find) return;
        }

        number[idx] = 0;
    }
}