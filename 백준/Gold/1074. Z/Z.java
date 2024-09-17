import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = (int)Math.pow(2, sc.nextInt());
        int r = sc.nextInt();
        int c = sc.nextInt();
        
        dfs(r, c, 0, 0, 0, n);
        
        System.out.print(answer);
        
    }
    
    static int answer = 0;
    
    public static void dfs(int r, int c, int startX, int startY, int num, int size) {
        if(size == 1) {
            answer = num;
            return;
        }
        
        int midX = (size / 2) + startX;
        int midY = (size / 2) + startY;
        int add = size * size / 4;
        
        if(r < midX && c < midY) {
            dfs(r, c, startX, startY, num, size / 2);
        } else if(r < midX && c >= midY) {
            dfs(r, c, startX, midY, num + add, size / 2);
        } else if(r >= midX && c < midY) {
            dfs(r, c, midX, startY, num + add * 2, size / 2);
        } else {
            dfs(r, c, midX, midY, num + add * 3, size / 2);
        }
        
    }
}