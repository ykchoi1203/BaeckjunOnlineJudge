import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] arr = new int[r][c];
        int x1 = -1;
        int x2 = -1;
        for(int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<c; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == -1) {
                    if(x1 == -1) {
                        x1 = i;
                    } else {
                        x2 = i;
                    }
                }
            }
        }

        for(int i=0; i<t; i++) {
            arr = moveAir(arr);
            move(arr, x1, x2);
        }

        int cnt = 0;

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(arr[i][j] > 0) {
                    cnt+=arr[i][j];
                }
            }
        }

        System.out.println(cnt);

    }

    static int r;
    static int c;

    public static void move(int[][] arr, int x1, int x2) {
        int temp = arr[x1][1];
        arr[x1][1] = 0;
        for(int i=x1, j=2;;) {
            int newTemp = arr[i][j];
            if(i == x1 && j == 0) {
                break;
            }
            arr[i][j] = temp;
            temp = newTemp;
            if(i == x1 && j < c-1) {
                j++;
            } else if(j == c-1 && i > 0) {
                i--;
            } else if(i == 0 && j > 0) {
                j--;
            } else {
                i++;
            }
        }

        temp = arr[x2][1];
        arr[x2][1] = 0;
        for(int i=x2, j=2;;) {
            int newTemp = arr[i][j];
            if(i == x2 && j == 0) {
                break;
            }
            arr[i][j] = temp;
            temp = newTemp;
            if(i == x2 && j < c-1) {
                j++;
            } else if(j == c-1 && i < r-1) {
                i++;
            } else if(i == r-1 && j > 0) {
                j--;
            } else {
                i--;
            }
        }
    }

    public static int[][] moveAir(int[][] arr) {
        int[][] newArr = new int[arr.length][arr[0].length];
        int[][] dxdy = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                if(arr[i][j] != 0) {
                    int k = arr[i][j] / 5;

                    for(int[] d : dxdy) {
                        int x = d[0] + i;
                        int y = d[1] + j;

                        if(x >= 0 && x < arr.length && y >= 0 && y < arr[i].length && arr[x][y] != -1) {
                            newArr[x][y] += k;
                            arr[i][j] -= k;
                        }
                    }

                    newArr[i][j] += arr[i][j];
                }
            }
        }

        return newArr;
    }
}
