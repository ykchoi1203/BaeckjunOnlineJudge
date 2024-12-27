import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Map<Integer, Node> map = new HashMap<>();
        
        for(int i=0; i<n; i++) {
            map.put(i, new Node(i));
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int startNode = 0;
        
        for(int i=0; i<n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) {
                map.get(i).setParent(null);
                startNode = i;
            } else {
                map.get(i).setParent(map.get(parent));
                map.get(parent).addChild(map.get(i));
            }
        }
        
        int remove = Integer.parseInt(br.readLine());
        
        if(remove == startNode) {
            System.out.println(0);
            return;
        }
        
        map.get(map.get(remove).parent.idx).children.remove(map.get(remove));
        
        count(map.get(startNode));
        
        System.out.println(cnt);
        
    }
    
    static int cnt = 0;
    
    public static void count(Node node) {
        if(node.children.isEmpty()) {
            cnt++;
            return;
        }
        
        for(Node child : node.children) {
            count(child);
        }
    }
    
    public static class Node {
        int idx;
        Node parent;
        ArrayList<Node> children;
        
        public Node(int idx) {
            this.idx = idx;
            children = new ArrayList<>();
        }
        
        public Node(int idx, Node parent) {
            this.idx = idx;
            this.parent = parent;
            children = new ArrayList<>();
        }
        
        public void setParent(Node parent) {
            this.parent = parent;
        }
        
        public void addChild(Node child) {
            children.add(child);
        }
    }
}