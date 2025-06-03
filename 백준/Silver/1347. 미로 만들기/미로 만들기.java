import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String str = br.readLine();

        int[][] arr = new int[1][1];
        arr[0][0] = 1;

        int x = 0, y = 0;


        int dir = 3; // 1 북 2 동 3 남 4 서

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == 'L') {
                dir--;
                if(dir == 0) dir = 4;
            } else if(ch == 'R') {
                dir++;
                if(dir == 5) dir = 1;
            } else {
                switch(dir) {
                    case 1:
                        x--;
                        if(x < 0) {
                            int[][] newArr = new int[arr.length + 1][arr[0].length];

                            for(int j = 0; j < arr.length; j++) {
                                for(int k = 0; k < arr[0].length; k++) {
                                    newArr[j + 1][k] = arr[j][k];
                                }
                            }

                            newArr[0][y] = 1;
                            x = 0;
                            arr = newArr;
                        } else {
                            arr[x][y] = 1;
                        }
                        break;
                    case 2:
                        y++;
                        if(y >= arr[0].length) {
                            int[][] newArr = new int[arr.length][arr[0].length + 1];

                            for(int j = 0; j < arr.length; j++) {
                                for(int k = 0; k < arr[0].length; k++) {
                                    newArr[j][k] = arr[j][k];
                                }
                            }

                            newArr[x][y] = 1;
                            arr = newArr;
                        }
                        break;
                    case 3:
                        x++;
                        if(x >= arr.length) {
                            int[][] newArr = new int[arr.length + 1][arr[0].length];

                            for(int j = 0; j < arr.length; j++) {
                                for(int k = 0; k < arr[0].length; k++) {
                                    newArr[j][k] = arr[j][k];
                                }
                            }

                            newArr[x][y] = 1;
                            arr = newArr;
                        }
                        break;
                    case 4:
                        y--;
                        if(y < 0) {
                            int[][] newArr = new int[arr.length][arr[0].length + 1];

                            for(int j = 0; j < arr.length; j++) {
                                for(int k = 0; k < arr[0].length; k++) {
                                    newArr[j][k + 1] = arr[j][k];
                                }
                            }

                            newArr[x][0] = 1;
                            y = 0;
                            arr = newArr;
                        }
                        break;
                }
                arr[x][y] = 1;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 1) sb.append(".");
                else sb.append("#");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }
}
