import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[][] arr = new int[4][2];
        
        for(int i=0; i<3; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        
        arr[3][0] = arr[0][0];
        arr[3][1] = arr[0][1];
        
        int sum = 0;
        
        for(int i=0; i<3; i++) {
            sum += arr[i][0] * arr[i+1][1];
            sum -= arr[i][1] * arr[i+1][0];
        }
        
        int answer = 0;
        
        if(sum > 0) {
            answer = 1;
        } else if(sum < 0) {
            answer = -1;
        }
        
        System.out.println(answer);
    }
}