import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++) {
            int k = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            boolean isZero = false;

            for(int j = 1; j <= k; j++) {
                String cur = st.nextToken();
                int idx = mbti.indexOf(cur);
                cnt[idx]++;
                if(cnt[idx] > 2) {
                    isZero = true;
                    break;
                }
            }

            sb.append(isZero ? 0 : dfs(0, 0)).append("\n");

            cnt = new int[16];
        }

        System.out.println(sb.toString());

    }

    static int[] arr = new int[3];
    static ArrayList<String> mbti = new ArrayList<>(List.of("ISTJ", "ISFJ", "INFJ", "INTJ", "ISTP", "ISFP", "INFP", "INTP", "ESTP", "ESFP", "ENFP", "ENTP", "ESTJ", "ESFJ", "ENFJ", "ENTJ"));
    static int[] cnt = new int[16];

    public static int dfs(int idx, int depth) {
        if(depth == 3) {
            int sum = 0;
            for(int i = 0; i < 4; i++) {
                if(mbti.get(arr[0]).charAt(i) != mbti.get(arr[1]).charAt(i)) {
                    sum++;
                }

                if(mbti.get(arr[1]).charAt(i) != mbti.get(arr[2]).charAt(i)) {
                    sum++;
                }

                if(mbti.get(arr[2]).charAt(i) != mbti.get(arr[0]).charAt(i)) {
                    sum++;
                }
            }

            return sum;
        }

        int min = Integer.MAX_VALUE;

        for(int i = idx; i < 16; i++) {
            if(cnt[i] > 0) {
                arr[depth] = i;
                cnt[i]--;
                min = Math.min(min, dfs(cnt[i] == 0 ? i + 1 : i, depth + 1));
                arr[depth] = 0;
                cnt[i]++;
            }
        }

        return min;

    }

}
