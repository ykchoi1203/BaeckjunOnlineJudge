import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int height = sc.nextInt();
        int[] arr = new int[num];
        int max = 0;
        for(int i=0; i<num; i++) {
           arr[i] = sc.nextInt();
           if(max < arr[i]) max = arr[i];
        }

        int min = 0;

        while(min < max) {
            long sum = 0;
            int mid = (max + min)/2;
            for(int i : arr) {
                if( i - mid > 0) {
                    sum += i - mid;
                }
            }
            if(sum >= height) {
                min = mid + 1;
            } else if (sum < height){
                max = mid;
            }
        }
        System.out.println(min - 1);
    }

}
