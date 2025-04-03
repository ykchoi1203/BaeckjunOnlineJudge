import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        s = br.readLine().split(" ");

        big(0);
        arr = new int[n + 1];
        visited = new boolean[10];
        small(0);

        System.out.println(Long.toString(big).length() < n + 1 ? "0" + big : big);
        System.out.println(Long.toString(small).length() < n + 1 ? "0" + small : small);

    }

    static Long big;
    static Long small;
    static int n;
    static boolean[] visited = new boolean[10];
    static String[] s;
    static int[] arr;

    static void big(int idx) {
        if(idx == n + 1) {
            big = 0L;
            long k = 1;
            for(int i=n; i>= 0; i--) {
                big += arr[i] * k;
                k *= 10;
            }
            return;
        }

        for(int i=9; i >= 0; i--) {
            if(!visited[i]) {
                if(idx == 0) {
                    visited[i] = true;
                    arr[idx] = i;
                    big(idx + 1);
                    visited[i] = false;
                } else if(s[idx - 1].equals("<")) {
                    if(arr[idx - 1] < i) {
                        visited[i] = true;
                        arr[idx] = i;
                        big(idx + 1);
                        visited[i] = false;
                    } else {
                        return;
                    }
                } else {
                    if(arr[idx - 1] > i) {
                        visited[i] = true;
                        arr[idx] = i;
                        big(idx + 1);
                        visited[i] = false;
                    } else {
                        return;
                    }
                }
            }

            if(big != null) return;
        }
    }

    static void small(int idx) {
        if(idx == n + 1) {
            small = 0L;
            long k = 1;
            for(int i=n; i>= 0; i--) {
                small += arr[i] * k;
                k *= 10;
            }
            return;
        }

        for(int i=0; i <= 9; i++) {
            if(!visited[i]) {
                if(idx == 0) {
                    visited[i] = true;
                    arr[idx] = i;
                    small(idx + 1);
                    visited[i] = false;
                } else if(s[idx - 1].equals("<")) {
                    if(arr[idx - 1] < i) {
                        visited[i] = true;
                        arr[idx] = i;
                        small(idx + 1);
                        visited[i] = false;
                    } else {
                        return;
                    }
                } else {
                    if(arr[idx - 1] > i) {
                        visited[i] = true;
                        arr[idx] = i;
                        small(idx + 1);
                        visited[i] = false;
                    } else {
                        return;
                    }
                }
            }

            if(small != null) return;
        }
    }
}
