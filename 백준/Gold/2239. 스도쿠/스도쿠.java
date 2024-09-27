import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String s = br.readLine();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = (s.charAt(j) - '0');
            }
        }

        checkSudoku(0, 0);

        for(int[] arr : sudoku) {
            for(int i : arr) {
                System.out.print(i);
            }
            System.out.println();
        }

    }

    static int[][] sudoku = new int[9][9];

    public static boolean checkSudoku(int i, int j) {
        boolean isTrue = false;
        if(sudoku[i][j] == 0) {
            for(int k=1; k<=9; k++) {
                sudoku[i][j] = k;
                if(checkBox(i, j) && checkLine(i, j)) {
                    if(i == 8 && j == 8) {
                        return true;
                    } else if(j == 8) {
                        isTrue = checkSudoku(i+1, 0);
                    } else {
                        isTrue = checkSudoku(i, j+1);
                    }
                    if(isTrue) {
                        return true;
                    }
                }
            }
            sudoku[i][j] = 0;
        } else {
            if(i == 8 && j == 8) {
                return true;
            } else if(j == 8) {
                isTrue = checkSudoku(i+1, 0);
            } else {
                isTrue = checkSudoku(i, j+1);
            }
            if(isTrue) {
                return true;
            }
        }
        return isTrue;
    }

    public static boolean checkBox(int i, int j) {
        int startX = (i / 3) * 3;
        int startY = (j / 3) * 3;

        for(int k = startX; k < startX + 3; k++) {
            for(int l = startY; l < startY + 3; l++) {
                if((k != i || l != j) && sudoku[k][l] == sudoku[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean checkLine(int i, int j) {
        for(int k = 0; k < 9; k++) {
            if((k != j && sudoku[i][k] == sudoku[i][j]) || (k != i && sudoku[k][j] == sudoku[i][j])) {
                return false;
            }
        }
        return true;
    }
}
