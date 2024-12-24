import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] two = new int[][] {
                {0, 1}, {0, 2}, {0, 3}, {0, 4},
                {1, 2}, {1, 3}, {1, 5},
                {2, 4}, {2, 5},
                {3, 4}, {3, 5},
                {4, 5}};

        int[][] three = new int[][] {{0, 1, 2}, {0, 1, 3}, {0, 3, 4}, {0, 2, 4},
                {1, 2, 5}, {1, 3, 5}, {2, 4, 5}, {3, 4, 5}};

        int minOne = Integer.MAX_VALUE;
        int minTwo = Integer.MAX_VALUE;
        int minThree = Integer.MAX_VALUE;

        String[] s = br.readLine().split(" ");
        
        if(n == 1) {
            int max = 0;
            int sum = 0;
            for(String num : s) {
                sum += Integer.parseInt(num);
                max = Math.max(max, Integer.parseInt(num));
            }
            System.out.println(sum - max);
            return;
        }

        for(int i = 0; i < 6; i++) {
            minOne = Math.min(minOne, Integer.parseInt(s[i]));
        }

        for(int[] t : two) {
            minTwo = Math.min(minTwo, Integer.parseInt(s[t[0]]) + Integer.parseInt(s[t[1]]));
        }

        for(int[] t : three) {
            minThree = Math.min(minThree, Integer.parseInt(s[t[0]]) + Integer.parseInt(s[t[1]]) + Integer.parseInt(s[t[2]]));
        }

        long answer = 0;

        answer += minThree * 4L + minTwo * ((n-1) * 4L + (n-2) * 4L) + minOne * ((long)n * n * 5 - 4 * 3 - 2 * ((n-1) * 4L + (n-2) * 4L));

        System.out.println(answer);

    }
}
