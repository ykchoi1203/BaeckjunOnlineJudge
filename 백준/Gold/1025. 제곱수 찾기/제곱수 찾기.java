import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int n = Integer.parseInt(NM[0]);
        int m = Integer.parseInt(NM[1]);

        arr = new int[n][m];

        for(int i=0; i<n; i++) {
            String[] nums = br.readLine().split("");
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(nums[j]);
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j] == 0 || arr[i][j] == 1 || arr[i][j] == 4 || arr[i][j] == 9) {
                    answer = Math.max(answer, arr[i][j]);
                }

                goLeftDown(i, j);
                goRightDown(i, j);
                goDown(i, j);
                goRight(i, j);

            }
        }

        System.out.println(answer);

    }

    public static int[][] arr;

    public static long answer = -1;

    public static boolean isTrue(long n) {
        return Math.floor(Math.sqrt(n)) == Math.sqrt(n);
    }

    public static void goLeftDown(int x, int y) {
        for(int k=1; k < arr.length ; k++) {
            for(int l=1; l < arr[x].length; l++) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; arr.length > i * k + x && 0 <= y - i * l ; i ++) {
                    sb.append(arr[i * k + x][y - i * l]);

                    if (isTrue(Long.parseLong(sb.toString()))) {
                        answer = Math.max(answer, Long.parseLong(sb.toString()));
                    }

                    if (isTrue(Long.parseLong(sb.reverse().toString()))) {
                        answer = Math.max(answer, Long.parseLong(sb.toString()));
                    }
                    sb.reverse();

                }
            }
        }
    }

    public static void goRightDown(int x, int y) {
        for(int k=1; k < arr.length ; k++) {
            for(int l=1; l < arr[x].length; l++) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; arr.length > i * k + x && arr[x].length > y + i * l ; i ++) {
                    sb.append(arr[i * k + x][y + i * l]);

                    if (isTrue(Long.parseLong(sb.toString()))) {
                        answer = Math.max(answer, Long.parseLong(sb.toString()));
                    }

                    if (isTrue(Long.parseLong(sb.reverse().toString()))) {
                        answer = Math.max(answer, Long.parseLong(sb.toString()));
                    }
                    sb.reverse();

                }
            }
        }
    }

    public static void goRight(int x, int y) {
        for(int k=1; k < arr[x].length; k++) {
            StringBuilder sb = new StringBuilder();
            for (int i = y; i < arr[x].length; i+=k) {
                sb.append(arr[x][i]);

                if (isTrue(Long.parseLong(sb.toString()))) {
                    answer = Math.max(answer, Long.parseLong(sb.toString()));
                }

                if (isTrue(Long.parseLong(sb.reverse().toString()))) {
                    answer = Math.max(answer, Long.parseLong(sb.toString()));
                }
                sb.reverse();
            }
        }
    }

    public static void goDown(int x, int y) {
        for (int k = 1; k < arr.length; k++) {
            StringBuilder sb = new StringBuilder();
            for (int i = x; i < arr.length; i+=k) {
                sb.append(arr[i][y]);

                if (isTrue(Long.parseLong(sb.toString()))) {
                    answer = Math.max(answer, Long.parseLong(sb.toString()));
                }

                if (isTrue(Long.parseLong(sb.reverse().toString()))) {
                    answer = Math.max(answer, Long.parseLong(sb.toString()));
                }
                sb.reverse();
            }
        }
    }
}

