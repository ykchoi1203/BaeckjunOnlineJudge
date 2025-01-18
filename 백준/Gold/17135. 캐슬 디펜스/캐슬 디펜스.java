import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        int count = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) count++;
            }
        }

        int answer = 0;

        for(int i=0; i<m-2; i++) {
            for(int j=i+1; j<m-1; j++) {
                for(int k=j+1; k<m; k++) {
                    int[][] copy = new int[n][];
                    int left = count;
                    for(int l=0; l<n; l++) {
                        copy[l] = arr[l].clone();
                    }

                    int[] team = new int[] {i, j, k};
                    int newCount = 0;
                    while(left > 0) {
                        Set<int[]> set = new HashSet<>();
                        for(int s : team) {
                            remove(copy, s, set);
                        }

                        for(int[] removes : set) {
                            if(copy[removes[0]][removes[1]] == 1) {
                                copy[removes[0]][removes[1]] = 0;
                                left--;
                                newCount++;
                            }
                        }

                        left = move(copy, left);

                    }

                    answer = Math.max(answer, newCount);
                }
            }
        }

        System.out.println(answer);

    }

    static int n;
    static int m;
    static int d;
    static int[][] arr;

    public static void remove(int[][] copyArr,int y, Set<int[]> set) {
        int min = d + 1;
        int minX = 0;
        int minY = 0;
        boolean isRemoved = false;
        for(int i=n-1; i >= 0 && n - i <= d; i--) {
            for(int j=0; j < m; j++) {
                if(copyArr[i][j] == 1 && n - i + Math.abs(y - j) <= d && min > n - i + Math.abs(y - j)) {
                    minX = i;
                    minY = j;
                    min = n - i + Math.abs(y - j);
                    isRemoved = true;
                } else if(copyArr[i][j] == 1 && n - i + Math.abs(y - j) <= d && min == n - i + Math.abs(y - j) && minY > j) {
                    minX = i;
                    minY = j;
                }
            }
        }

        if(isRemoved) {
            set.add(new int[]{minX, minY});
        }
    }

    public static int move(int[][] copyArr, int left) {
        for(int i=0; i<m; i++) {
            if(copyArr[n-1][i] == 1) {
                left--;
            }
        }

        for(int i=n-1; i>=1; i--) {
            copyArr[i] = copyArr[i-1].clone();
        }
        Arrays.fill(copyArr[0], 0);
        return left;
    }

}
