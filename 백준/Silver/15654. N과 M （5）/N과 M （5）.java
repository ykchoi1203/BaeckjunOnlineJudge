import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        dfs(arr, visited, 0, new int[m]);

        System.out.print(sb.toString());

    }

    static StringBuilder sb = new StringBuilder();

    public static void dfs(int[] arr, boolean[] visited, int idx, int[] answer) {
        if(idx == answer.length) {
            for(int number : answer) {
                sb.append(number).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<arr.length; i++) {
            if(!visited[i]) {
                answer[idx] = arr[i];
                visited[i] = true;
                dfs(arr, visited, idx+1, answer);
                visited[i] = false;
            }
        }

    }
}