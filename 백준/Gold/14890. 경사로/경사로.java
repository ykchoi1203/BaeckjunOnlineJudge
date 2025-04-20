import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        int[][] makeLoad = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        for(int i = 0; i < n; i++) {
            int lastHeight = arr[i][0];
            boolean isTrue = true;
            int plusMinus = 0;
            loop:
            for(int j = 1; j < n; j++) {
                if(arr[i][j] < lastHeight) {
                    if(n - j < l || arr[i][j] + 1 != lastHeight) {
                        isTrue = false;
                        break loop;
                    }

                    if(arr[i][j] < lastHeight) {
                        plusMinus = -1;
                    } else if(arr[i][j] > lastHeight) {
                        plusMinus = 1;
                    }

                    for(int k = j; k < j + l && k < n; k++) {
                        if(arr[i][k] != arr[i][j]) {
                            isTrue = false;
                            break loop;
                        }
                    }

                    for(int k = j; k < j + l && k < n; k++) {
                        makeLoad[i][k] = plusMinus;
                    }
                    j += l - 1;
                    lastHeight = arr[i][j];
                } else {
                    lastHeight = arr[i][j];
                }

            }

            if(isTrue) {
                lastHeight = arr[i][n - 1];
                isTrue = true;
                plusMinus = 0;
                loop:
                for(int j = n-2; j >= 0; j--) {
                    if(arr[i][j] < lastHeight) {
                        if(j + 1 < l || arr[i][j] + 1 != lastHeight) {
                            isTrue = false;
                            break loop;
                        }

                        if(arr[i][j] < lastHeight) {
                            plusMinus = -1;
                        } else if(arr[i][j] > lastHeight) {
                            plusMinus = 1;
                        }

                        for(int k = j; k > j - l && k >= 0; k--) {
                            if(arr[i][k] != arr[i][j] || (makeLoad[i][k] != 0 && makeLoad[i][k] != -plusMinus)) {
                                isTrue = false;
                                break loop;
                            }
                        }
                        j -= l - 1;
                        lastHeight = arr[i][j];
                    } else {
                        lastHeight = arr[i][j];
                    }

                }
            }

            if(isTrue) answer++;
        }

        makeLoad = new int[n][n];

        for(int i = 0; i < n; i++) {
            int lastHeight = arr[0][i];
            boolean isTrue = true;
            int plusMinus = 0;
            loop:
            for(int j = 1; j < n; j++) {
                if(arr[j][i] < lastHeight ) {
                    if(n - j < l || arr[j][i] + 1 != lastHeight) {
                        isTrue = false;
                        break loop;
                    }

                    if(arr[j][i] < lastHeight) {
                        plusMinus = -1;
                    } else if(arr[j][i] > lastHeight) {
                        plusMinus = 1;
                    }

                    for(int k = j; k < j + l && k < n; k++) {
                        if(arr[k][i] != arr[j][i]) {
                            isTrue = false;
                            break loop;
                        }
                    }

                    for(int k = j; k < j + l && k < n; k++) {
                        makeLoad[k][i] = plusMinus;
                    }

                    lastHeight = arr[j][i];
                    j += l - 1;
                } else {
                    lastHeight = arr[j][i];
                }

            }

            if(isTrue) {
                lastHeight = arr[n - 1][i];
                isTrue = true;
                plusMinus = 0;
                loop:
                for(int j = n-2; j >= 0; j--) {
                    if(arr[j][i] < lastHeight ) {
                        if(j + 1 < l || arr[j][i] + 1 != lastHeight) {
                            isTrue = false;
                            break loop;
                        }

                        if(arr[j][i] < lastHeight) {
                            plusMinus = -1;
                        } else if(arr[j][i] > lastHeight) {
                            plusMinus = 1;
                        }

                        for(int k = j; k > j - l && k >= 0; k--) {
                            if(arr[k][i] != arr[j][i] || (makeLoad[k][i] != 0 && makeLoad[k][i] != -plusMinus)) {
                                isTrue = false;
                                break loop;
                            }
                        }
                        j -= l - 1;
                        lastHeight = arr[j][i];
                    } else {
                        lastHeight = arr[j][i];
                    }

                }
            }

            if(isTrue) {
                answer++;
            }
        }

        System.out.println(answer);

    }
}
