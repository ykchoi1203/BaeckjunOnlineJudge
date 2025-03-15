import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[st.countTokens() - 1];

        if(arr.length == 0) {
            System.out.println(0);
            return;
        }

        for(int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int[][] dp = new int[arr.length][17];

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<list.length; i++) {
            map.put(list[i], i);
        }

        Arrays.fill(dp[0], Integer.MAX_VALUE);

        dp[0][map.get(arr[0] * 10)] = 2;

        for(int i = 1; i < arr.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for(int j=0; j<17; j++) {
                if(dp[i-1][j] == Integer.MAX_VALUE) {
                    continue;
                }

                int a = list[j] / 10;
                int b = list[j] % 10;

                if((arr[i] == a || arr[i] == b)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                    continue;
                }

                if(arr[i] == 1) {
                    if(a == 2 ||  a == 4) {
                        int next = 10 + b;

                        if(map.containsKey(next)) {
                            int nextIdx = map.get(next);

                            dp[i][nextIdx] = Math.min(dp[i-1][j] + 3, dp[i][nextIdx]);
                        }
                    } else if(a == 3) {
                        int next = 10 + b;

                        if(map.containsKey(next)) {
                            int nextIdx = map.get(next);
                            dp[i][nextIdx] = Math.min(dp[i-1][j] + 4, dp[i][nextIdx]);
                        }
                    }

                    if(b == 2 || b == 4) {
                        int next = a * 10 + 1;

                        if(map.containsKey(next)) {
                            int nextIdx = map.get(next);
                            dp[i][nextIdx] = Math.min(dp[i-1][j] + 3, dp[i][nextIdx]);
                        }
                    } else if(b == 3) {
                        int next = a * 10 + 1;

                        if(map.containsKey(next)) {
                            int nextIdx = map.get(next);
                            dp[i][nextIdx] = Math.min(dp[i-1][j] + 4, dp[i][nextIdx]);
                        }
                    } else {
                        int next = a * 10 + 1;

                        if(map.containsKey(next)) {
                            int nextIdx = map.get(next);
                            dp[i][nextIdx] = Math.min(dp[i-1][j] + 2, dp[i][nextIdx]);
                        }
                    }

                } else if(arr[i] == 4) {
                    if(a == 1 ||  a == 3) {
                        int next = 40 + b;

                        if(map.containsKey(next)) {
                            int nextIdx = map.get(next);

                            dp[i][nextIdx] = Math.min(dp[i-1][j] + 3, dp[i][nextIdx]);
                        }
                    } else if(a == 2) {
                        int next = 40 + b;

                        if(map.containsKey(next)) {
                            int nextIdx = map.get(next);
                            dp[i][nextIdx] = Math.min(dp[i-1][j] + 4, dp[i][nextIdx]);
                        }
                    }

                    if(b == 1 || b == 3) {
                        int next = a * 10 + 4;

                        if(map.containsKey(next)) {
                            int nextIdx = map.get(next);
                            dp[i][nextIdx] = Math.min(dp[i-1][j] + 3, dp[i][nextIdx]);
                        }
                    } else if(b == 2) {
                        int next = a * 10 + 4;

                        if(map.containsKey(next)) {
                            int nextIdx = map.get(next);
                            dp[i][nextIdx] = Math.min(dp[i-1][j] + 4, dp[i][nextIdx]);
                        }
                    }  else {
                        int next = a * 10 + 4;

                        if(map.containsKey(next)) {
                            int nextIdx = map.get(next);
                            dp[i][nextIdx] = Math.min(dp[i-1][j] + 2, dp[i][nextIdx]);
                        }
                    }
                } else {
                    if(Math.abs(a - arr[i]) == 1) {
                        int next = 10 * arr[i] + b;

                        if(map.containsKey(next)) {
                            int nextIdx = map.get(next);

                            dp[i][nextIdx] = Math.min(dp[i-1][j] + 3, dp[i][nextIdx]);
                        }
                    } else {
                        int next = 10 * arr[i] + b;

                        if(map.containsKey(next)) {
                            int nextIdx = map.get(next);
                            dp[i][nextIdx] = Math.min(dp[i-1][j] + 4, dp[i][nextIdx]);
                        }
                    }

                    if(Math.abs(b - arr[i]) == 1 && b != 0) {
                        int next = a * 10 + arr[i];

                        if(map.containsKey(next)) {
                            int nextIdx = map.get(next);
                            dp[i][nextIdx] = Math.min(dp[i-1][j] + 3, dp[i][nextIdx]);
                        }
                    } else if(b != 0) {
                        int next = a * 10 + arr[i];

                        if(map.containsKey(next)) {
                            int nextIdx = map.get(next);
                            dp[i][nextIdx] = Math.min(dp[i-1][j] + 4, dp[i][nextIdx]);
                        }
                    } else {
                        int next = a * 10 + arr[i];

                        if(map.containsKey(next)) {
                            int nextIdx = map.get(next);
                            dp[i][nextIdx] = Math.min(dp[i-1][j] + 2, dp[i][nextIdx]);
                        }
                    }
                }


            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i=0; i<dp[arr.length-1].length; i++) {
            answer = Math.min(answer, dp[arr.length-1][i]);
        }

        System.out.println(answer);
    }
    static int[] list = {0, 10, 20, 30, 40, 12, 13, 14, 21, 23, 24, 31, 32, 34, 41, 42, 43};
}
