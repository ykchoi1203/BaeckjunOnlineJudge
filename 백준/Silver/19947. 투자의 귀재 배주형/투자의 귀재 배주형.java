import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int h = sc.nextInt();
        
        int y = sc.nextInt();
        
        int[] arr = new int[1 + y];
        arr[0] = h;
        
        double[] k = new double[] {1.05, 1.2, 1.35};
        
        for(int i = 0; i < y; i++) {
            for(int j = 0; j < 3 && i + 2 * j + 1 <= y; j++) {
                arr[i + 2 * j + 1] = Math.max(arr[i + 2 * j + 1], (int)(arr[i] * k[j]));
            }
        }
        
        System.out.println(arr[y]);
    }
}