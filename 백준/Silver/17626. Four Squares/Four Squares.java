import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        number = sc.nextInt();

        visited = new boolean[number + 1];

        map.put(1, new ArrayList<>());
        map.put(2, new ArrayList<>());
        map.put(3, new ArrayList<>());
        map.put(4, new ArrayList<>());

        for(int i=1; i<=Math.sqrt(number); i++) {
            map.get(1).add(i*i);
            visited[i*i] = true;
        }

        if(visited[number]) {
            System.out.println("1");
            return;
        }

        addNumber(map.get(1), map.get(1), 2);
        if(visited[number]) {
            System.out.println("2");
            return;
        }

        addNumber(map.get(1), map.get(2), 3);
        addNumber(map.get(2), map.get(1), 3);
        if(visited[number]) {
            System.out.println("3");
            return;
        }

        System.out.println(4);

    }

    static boolean[] visited;
    static Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    static int number;

    public static void addNumber(ArrayList<Integer> list1, ArrayList<Integer> list2, int num) {
        for(int num1 : list1) {
            for(int num2 : list2) {
                if(num1 + num2 > number) break;
                if(!visited[num1 + num2]) {
                    visited[num1 + num2] = true;
                    map.get(num).add(num1 + num2);
                }
            }
        }
    }
}
