import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            map.put(i+1, new HashSet<>());
        }
        
        for(int i=0; i<n; i++) {
            for(int j=n-1; j>=i; j--) {
                if(arr[i] == arr[j]) {
                    boolean isTrue = true;
                    for(int k=0; k < (j+1-i)/2; k++) {
                        if(arr[i + k] != arr[j-k]) {
                            isTrue = false;
                            break;
                        }
                    }
                    if(isTrue) {
                        map.get(i+1).add(j+1);
                    }
                }
            }
        }
        
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<m; i++) {
            String[] nums = br.readLine().split(" ");
            
            if(map.get(Integer.parseInt(nums[0])).contains(Integer.parseInt(nums[1]))) {
                sb.append("1\n");        
            } else {
                sb.append("0\n");
            }
        }
        
        System.out.println(sb.toString());
        
    }
}