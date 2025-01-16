import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        angle.add(0);

        dfs(0, 0);

        System.out.println(answer);

    }

    static int[] arr;
    static Set<Integer> set = new HashSet<>();
    static Set<Integer> angle = new HashSet<>();
    static int answer = 0;
    static int n;

    public static void dfs(int angleSum, int count) {
        if(set.size() == n - 1) {
            answer = Math.max(answer, count);
            return;
        }

        for(int i=0; i<n; i++) {
            if(set.contains(i)) {
                continue;
            }

            int addAngle = angleSum + arr[i] * 36;

            angle.add(addAngle);
            set.add(i);

            if(angle.contains(addAngle - 1800)) {
                dfs(addAngle, count + 1);
            } else {
                dfs(addAngle, count);
            }

            angle.remove(addAngle);
            set.remove(i);
        }
    }

    public static int getAnswer(int[] arr) {
        Set<Integer> set = new HashSet<>();

        int answer = 0;
        int sum = 0;

        set.add(0);

        for (int j : arr) {
            sum += 36 * j;
            if (sum >= 1800 && set.contains(sum - 1800)) {
                answer++;
            } else if(sum < 1800) {
                set.add(sum);
            }
        }

        return answer;
    }
}
