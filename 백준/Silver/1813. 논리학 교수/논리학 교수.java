import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[51];

        for(int i=0; i<n; i++) {
            arr[sc.nextInt()]++;
        }

        int answer = -1;

        for(int i=0; i<51; i++) {
            if(arr[i] == i) {
                answer = i;
            }
        }

        System.out.println(answer);
    }
}