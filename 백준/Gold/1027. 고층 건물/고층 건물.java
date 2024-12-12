import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for(int i=1; i<=n; i++){
            Set<Double> set = new HashSet<>();
            int cnt = 0;
            double max = Double.NEGATIVE_INFINITY;
            for(int j=i-1; j>0; j--){
                double d = (arr[j]- arr[i]) / (double)Math.abs(j - i);
                if(max < d) {
                    set.add((arr[j]- arr[i]) / (double)Math.abs(j - i));
                    max = d;
                }
            }

            cnt += set.size();
            set = new HashSet<>();
            max = Double.NEGATIVE_INFINITY;
            for(int j=i+1; j<=n; j++){
                double d = (arr[j]- arr[i]) / (double)Math.abs(j - i);
                if(max < d) {
                    set.add((arr[j]- arr[i]) / (double)Math.abs(j - i));
                    max = d;
                }
            }
            cnt += set.size();
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
    }
}
