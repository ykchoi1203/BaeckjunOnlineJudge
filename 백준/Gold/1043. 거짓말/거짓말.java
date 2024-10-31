import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        boolean[] visitedParty = new boolean[m + 1];
        boolean[] visitedPerson = new boolean[n + 1];
        Map<Integer, ArrayList<Integer>> personToParty = new HashMap<>();
        Map<Integer, ArrayList<Integer>> partyToPerson = new HashMap<>();

        for(int i=1; i<=n; i++) {
            personToParty.put(i, new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            partyToPerson.put(i, new ArrayList<>());
        }

        Queue<Integer> queue = new LinkedList<>();

        st.nextToken();

        while(st.hasMoreTokens()) {
            int personIdx = Integer.parseInt(st.nextToken());
            queue.add(personIdx);
            visitedPerson[personIdx] = true;
        }

        for(int i=0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();

            while(st.hasMoreTokens()) {
                int personIdx = Integer.parseInt(st.nextToken());
                personToParty.get(personIdx).add(i);
                partyToPerson.get(i).add(personIdx);
            }
        }

        while(!queue.isEmpty()) {
            int curPersonIdx = queue.poll();

            for(int partyIdx : personToParty.get(curPersonIdx)) {
                if(!visitedParty[partyIdx]) {
                    visitedParty[partyIdx] = true;
                    m--;
                    for(int personIdx : partyToPerson.get(partyIdx)) {
                        if(!visitedPerson[personIdx]) {
                            visitedPerson[personIdx] = true;
                            queue.add(personIdx);
                        }
                    }
                }
            }
        }

        System.out.println(m);

    }
}
