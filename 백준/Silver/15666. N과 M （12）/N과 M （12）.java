import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int k = sc.nextInt();
        arr = new int[k];
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<n; i++) {
            set.add(sc.nextInt());
        }
        
        nums = new int[set.size()];
        
        int idx = 0;
        for(int num : set) {
            nums[idx++] = num;
        }
        
        Arrays.sort(nums);
        
        dfs(0, 0);
        
        System.out.println(sb.toString());
        
    }
    
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[] nums;
    
    static void dfs(int idx, int start) {
        if(idx == arr.length) {
            for(int num : arr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            
            return;
        }
        
        for(int i = start; i < nums.length; i++) {
            arr[idx] = nums[i];
            dfs(idx + 1, i);
        }
    }
}