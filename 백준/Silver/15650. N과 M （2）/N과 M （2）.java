import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[m];
        
        for(int i=1; i<=n; i++) {
            list.add(i);
        }
        
        dfs(list, 0, arr, 0);
        
    }
    
    public static void dfs(List<Integer> list, int idx, int[] arr, int curIdx) {
        if(curIdx == arr.length) {
            for(int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        
        for(int i=idx; i < list.size(); i++) {
            arr[curIdx] = list.get(i);
            dfs(list, i+1, arr, curIdx+1);
        }
    }
}