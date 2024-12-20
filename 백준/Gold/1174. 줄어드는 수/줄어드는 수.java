import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        if(n == 1) {
            System.out.println(0);
            return;
        }

        while(firstIdx >= 0) {
            for(int i=1; i<10; i++) {
                nums[firstIdx] = i;
                backTrack(firstIdx+1);
                if(count == n) break;
            }
            if(count == n) break;

            firstIdx--;
        }

        long answer = (long)nums[9];
        long ten = 10L;
        for(int i=8; i>=0; i--) {
            answer += ten * nums[i];
            ten *= 10;
        }

        System.out.println(count < n ? -1 : answer);
    }

    static int n;
    static int[] nums = new int[10];
    static int firstIdx = 9;
    static int count = 1;

    public static void backTrack(int idx) {
        if(idx == 10) {
            count++;
            return;
        }

        for(int i=0; i<nums[idx-1]; i++) {
            nums[idx] = i;
            backTrack(idx+1);
            if(count == n) return;
        }

    }
}
