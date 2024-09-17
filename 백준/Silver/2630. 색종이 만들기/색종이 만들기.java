import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[][] arr = new int[n][n];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        dfs(arr, 0, 0, n);
        
        System.out.println(zero);
        System.out.println(one);
        
    }
    
    static int zero = 0;
    static int one = 0;
    
    public static void dfs(int[][] arr, int startX, int startY, int size) {
        if(size == 1) {
            if(arr[startX][startY] == 0) {
                zero++;
            } else {
                one++;
            }
            return;
        }
        
        int num = arr[startX][startY];
        boolean isTrue = true;
        
        loop:
        for(int i=startX; i<startX+size; i++) {
            for(int j=startY; j<startY+size; j++) {
                if(arr[i][j] != num) {
                    isTrue = false;
                    break loop;
                }
            }
        }
        
        if(isTrue) {
            if(num == 0) {
                zero++;
            } else {
                one++;
            }
            return;
        }
        
        dfs(arr, startX, startY, size/2);
        dfs(arr, startX + size/2, startY, size/2);
        dfs(arr, startX, startY + size/2, size/2);
        dfs(arr, startX + size/2, startY + size/2, size/2);
    }
}