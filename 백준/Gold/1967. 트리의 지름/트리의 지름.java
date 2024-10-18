import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Map<Integer, Node> nodes = new HashMap<>();

        for(int i=1; i<=n; i++) {
            nodes.put(i, new Node(i));
        }

        for(int i=1; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            Node root = nodes.get(Integer.parseInt(st.nextToken()));
            Node child = nodes.get(Integer.parseInt(st.nextToken()));

            root.addChild(child);
            child.setRoot(root);
            child.setCost(Integer.parseInt(st.nextToken()));

        }

        int nodeMax = dfs(nodes.get(1));

        answer = Math.max(answer, nodeMax);

        System.out.println(answer);

    }

    static int answer = 0;

    public static int dfs(Node curNode) {
        if(curNode.children.isEmpty()) {
            return 0;
        }

        int max = 0;
        int secondMax = 0;

        for(Node nextNode : curNode.children) {
            int costs = dfs(nextNode) + nextNode.cost;

            if(max <= costs) {
                secondMax = max;
                max = costs;
            } else if(secondMax < costs) {
                secondMax = costs;
            }
        }

        if(secondMax != 0) {
            answer = Math.max(answer, max + secondMax);
        }

        return max;
    }

    public static class Node {
        Node root;
        int index;
        int cost;
        ArrayList<Node> children = new ArrayList<>();

        public Node(int index) {
            this.index = index;
        }

        public void setRoot(Node root) {
            this.root = root;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public void addChild(Node child) {
            children.add(child);
        }

        public int getIndex() {
            return index;
        }

        public Node getRoot() {
            return root;
        }

        public int getCost() {
            return cost;
        }

        public ArrayList<Node> getChildren() {
            return children;
        }

        public boolean isLastNode() {
            return children.isEmpty();
        }

    }
}
