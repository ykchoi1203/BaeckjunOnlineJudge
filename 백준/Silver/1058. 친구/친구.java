import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        int[][] arr2 = new int[n][n];

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) == 'N' ? 0 : 1;
                arr2[i][j] = arr[i][j];
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j || arr[i][j] == 0) continue;
                for(int k = 0; k < n; k++) {
                    if (arr[j][k] == 1) {
                        arr2[i][k] = 1;
                    }
                }
            }
        }

        int answer = 0;

        for(int i = 0; i < n; i++) {
            int cnt = 0;
            for(int j = 0; j < n; j++) {
                if(i != j && arr2[i][j] == 1) cnt++;
            }

            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);


    }
}
