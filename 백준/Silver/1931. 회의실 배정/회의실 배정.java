import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[n][2];
        
        for(int i=0; i<n; i++) {
            String[] cur = br.readLine().split(" ");
            
            arr[i][0] = Integer.parseInt(cur[0]);
            arr[i][1] = Integer.parseInt(cur[1]);
        }
        
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        int max = 0;
        
        for(int i=0; i<n; i++) {
            while(!queue.isEmpty() && queue.peek()[1] <= arr[i][0]) {
                queue.clear();
                max++;
            }
            queue.add(arr[i]);
        }
        int lastTime = queue.peek()[1];
        
        while(!queue.isEmpty()) {
            max++;
            lastTime = queue.peek()[1];
            while(!queue.isEmpty() && (queue.peek()[1] <= lastTime || queue.peek()[0] <= lastTime)) {
                queue.poll();
            }
        }
        
        System.out.println(max);
    }
}