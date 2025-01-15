import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int boxNum = Integer.parseInt(br.readLine());

        int[] boxes = new int[1000001];

        st = new StringTokenizer(br.readLine());

        int maxWeight = 0;

        for(int i=0; i<boxNum; i++) {
            int weight = Integer.parseInt(st.nextToken());
            boxes[weight]++;
            maxWeight = Math.max(maxWeight, weight);
        }

        if(maxWeight > arr[n - 1]) {
            System.out.println(-1);
            return;
        }

        int zeroSize = 0;
        int time = 0;
        int idx = 0;
        while(zeroSize < n) {
            boolean isTrue = false;
            for(int i=idx; i<n; i++) {
                while(arr[i] >= 0 && boxes[arr[i]] == 0) {
                    arr[i]--;
                }
                if(arr[i] >= 0) {
                    boxes[arr[i]]--;
                    isTrue = true;
                }
                else {
                    zeroSize++;
                    idx++;
                }
            }
            if(isTrue) {
                time++;
            } else break;
        }

        System.out.println(time);

    }
}
