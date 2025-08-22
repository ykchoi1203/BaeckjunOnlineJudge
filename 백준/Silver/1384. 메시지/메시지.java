import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n;
        int cnt = 1;
        while((n = Integer.parseInt(br.readLine())) != 0) {
            sb.append("Group ").append(cnt++).append("\n");
            ArrayList<String> name = new ArrayList<>();
            ArrayList<ArrayList<String>> messages = new ArrayList<>();

            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                name.add(st.nextToken());
                messages.add(new ArrayList<>());
                for(int j = 0; j < n - 1; j++) {
                    messages.get(i).add(st.nextToken());
                }
            }

            boolean anyOne = false;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n - 1; j++) {
                    if(messages.get(i).get(j).equals("N")) {
                        sb.append(name.get(i - 1 - j < 0 ? i - j + n - 1 : i - j - 1)).append(" was nasty about ").append(name.get(i)).append("\n");
                        anyOne = true;
                    }
                }
            }

            if(!anyOne) {
                sb.append("Nobody was nasty\n");
            }

            sb.append("\n");

        }

        System.out.println(sb);
    }
}