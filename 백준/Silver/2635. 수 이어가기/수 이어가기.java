import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int max = 0;
        StringBuilder sb = new StringBuilder();


        for(int i=1; i<=n; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            list.add(n);
            list.add(i);

            while(list.get(list.size() - 2) - list.get(list.size() - 1) >= 0) {
                list.add(list.get(list.size() - 2) - list.get(list.size() - 1));
            }

            if(list.size() > max) {
                max = list.size();
                sb = new StringBuilder();

                for(Integer j : list) {
                    sb.append(j).append(" ");
                }
            }
        }

        System.out.println(max);
        System.out.println(sb);
    }
}