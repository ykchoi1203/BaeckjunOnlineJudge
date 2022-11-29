import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int[] arr = new int[num];
        for(int i=0; i<num; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<arr.length; i++) {
            int[] num0 = new int[] {1, 0};
            int[] num1 = new int[] {0, 1};
            int cnt = 2;
            if(arr[i] == 0) {
                System.out.println(num0[0] + " " + num0[1]);
            }
            else if(arr[i] == 1){
                System.out.println(num1[0] + " " + num1[1]);
            }
            else {
                while (arr[i] >= cnt) {
                    int[] num2 = new int[] {num0[0] + num1[0], num0[1] + num1[1]};
                    num0 = num1;
                    num1 = num2;
                    cnt++;
                }
                System.out.println(num1[0] + " " + num1[1]);
            }
        }
    }
}