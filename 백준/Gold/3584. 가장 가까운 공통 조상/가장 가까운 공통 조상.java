import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        while(k-- > 0) {
            int n = Integer.parseInt(br.readLine());

            Node[] nodes = new Node[n + 1];

            for(int i = 0; i < n - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(nodes[a] == null) {
                    nodes[a] = new Node(a);
                }

                if(nodes[b] == null) {
                    nodes[b] = new Node(b);
                }

                nodes[a].children.add(nodes[b]);
                nodes[b].parent = nodes[a];

            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Set<Integer> getAParent = new HashSet<>();
            getAParent.add(a);
            while(nodes[a].parent != null) {
                getAParent.add(nodes[a].parent.value);
                a = nodes[a].parent.value;
            }
            
            if(getAParent.contains(b)) {
                System.out.println(b);
                continue;
            }

            while(nodes[b].parent != null) {
                if(getAParent.contains(nodes[b].parent.value)) {
                    System.out.println(nodes[b].parent.value);
                    break;
                }
                b = nodes[b].parent.value;
            }

        }

    }

    public static class Node {
        int value;
        Node parent;
        ArrayList<Node> children = new ArrayList<>();

        public Node(int value) {
            this.value = value;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public void addChild(Node child) {
            children.add(child);
        }
    }
}
