import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);
        
        dfs(arr, new int[m], 0, new boolean[n]);
        
        System.out.println(sb.toString());
        
    }
    
    static StringBuilder sb = new StringBuilder();
    
    public static void dfs(int[] arr, int[] num, int idx, boolean[] visited) {
        if(idx == num.length) {
            for(int number : num) {
                sb.append(number).append(" ");
            }
            sb.append("\n");
            return;
        }
        int lastNum = -1;
        for(int i=0; i<arr.length; i++) {
            if(i != 0 && lastNum != arr[i] && !visited[i]) {
                visited[i] = true;
                num[idx] = arr[i];
                lastNum = arr[i];
                dfs(arr, num, idx+1, visited);
                visited[i] = false;
            } else if(i == 0 && !visited[i]) {
                visited[i] = true;
                num[idx] = arr[i];
                lastNum = arr[i];
                dfs(arr, num, idx+1, visited);
                visited[i] = false;
            }
        }
    }
}