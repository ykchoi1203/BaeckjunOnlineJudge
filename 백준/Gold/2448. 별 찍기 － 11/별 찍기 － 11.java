import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        boolean[][] start = new boolean[3][5];
        start[0][2] = true;
        start[1][1] = true;
        start[1][3] = true;
        for(int i = -2; i <= 2; i++) {
            start[2][2 + i] = true;
        }

        while(start.length < n) {
            boolean[][] newStars = new boolean[start.length * 2][5 * (start.length * 2 / 3) + (start.length * 2 / 3 - 1)];
            draw(newStars, 0, newStars[0].length/2, start);
            draw(newStars, newStars.length/2, start[0].length/2, start);
            draw(newStars, newStars.length/2, newStars[0].length - start[0].length/2 - 1, start);
            start = newStars;
        }

        StringBuilder sb = new StringBuilder();

        for(boolean[] arr : start) {
            for(boolean t : arr) {
                if(t) sb.append("*");
                else sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }

    public static void draw(boolean[][] newStars, int x, int y, boolean[][] stars) {
        for(int i=x; i < x + stars.length; i++) {
            for(int j=y - stars[0].length/2; j <= y + stars[0].length/2; j++) {
                newStars[i][j] = stars[i-x][j+stars[0].length/2 - y];
            }
        }
    }
}
