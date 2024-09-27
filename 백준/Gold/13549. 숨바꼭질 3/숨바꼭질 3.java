import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        if(n >= m) {
            System.out.println((n-m));
            return;
        }
        
        int[] arr = new int[m * 2 + 1];
        
        Arrays.fill(arr, Integer.MAX_VALUE);
        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(n);
        arr[n] = 0;
        
        while(!queue.isEmpty()) {
            int num = queue.poll();
            
            if(num == m) {
                System.out.println(arr[m]);
                return;
            }
            
            int temp = num * 2;
            while(temp < arr.length && arr[num] < arr[temp]) {
                queue.add(temp);
                arr[temp] = arr[num];
                temp *= 2;
            }
            
            if(num > 0 && arr[num] + 1 < arr[num-1]) {
                queue.add(num - 1);
                arr[num - 1] = arr[num] + 1;
            }
            
            if(num < arr.length - 1 && arr[num] + 1 < arr[num+1]) {
                queue.add(num + 1);
                arr[num + 1] = arr[num] + 1;
            }
        }
        
    }
}