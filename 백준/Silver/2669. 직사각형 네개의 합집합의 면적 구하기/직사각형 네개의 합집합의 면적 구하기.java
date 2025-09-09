import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        boolean[][] arr = new boolean[100][100];
        
        for(int i=0; i<4; i++) {
            int x1 = sc.nextInt() - 1;
            int y1 = sc.nextInt() - 1;
            int x2 = sc.nextInt() - 1;
            int y2 = sc.nextInt() - 1;
            
            for(int j = x1; j < x2; j++) {
                for(int k = y1; k < y2; k++) {
                    arr[j][k] = true;
                }
            }
        }
        
        int answer = 0;
        
        for(int i=0; i<100; i++) {
            for(int j=0; j<100; j++) {
                if(arr[i][j]) answer++;
            }
        }
        
        System.out.println(answer);
    }
}