import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Map<Character, Node> map = new HashMap<>();
        
        for(int i=0; i<n; i++) {
            String[] cur = br.readLine().split(" ");
            if(map.containsKey(cur[0].charAt(0))) {
                Node rootNode = map.get(cur[0].charAt(0));
                
                if(!cur[1].equals(".")) {
                    addLeft(map, rootNode, cur[1].charAt(0));  
                }                 
                
                if(!cur[2].equals(".")) {
                     addRight(map, rootNode, cur[2].charAt(0));
                }
                
                map.put(rootNode.node, rootNode);
                
            } else {
                Node rootNode = new Node(cur[0].charAt(0));
                
                if(!cur[1].equals(".")) {
                    addLeft(map, rootNode, cur[1].charAt(0));  
                }                 
                
                if(!cur[2].equals(".")) {
                     addRight(map, rootNode, cur[2].charAt(0));
                }
                
                map.put(rootNode.node, rootNode);
                
            }
        }
        
        System.out.println(getPreorder(map, map.get('A'), new StringBuilder()).toString());
        System.out.println(getInorder(map, map.get('A'), new StringBuilder()).toString());
        System.out.println(getPostorder(map, map.get('A'), new StringBuilder()).toString());
        
    }
    
    public static StringBuilder getPreorder(Map<Character, Node> map, Node cur, StringBuilder sb) {
        if(cur == null) {
            return sb;
        }
        sb.append(cur.node);
        getPreorder(map, cur.getLeft(), sb);
        getPreorder(map, cur.getRight(), sb);
        return sb;
    }
    
    public static StringBuilder getInorder(Map<Character, Node> map, Node cur, StringBuilder sb) {
        if(cur == null) {
            return sb;
        }
        getInorder(map, cur.getLeft(), sb);
        sb.append(cur.node);
        getInorder(map, cur.getRight(), sb);
        return sb;
    }

    public static StringBuilder getPostorder(Map<Character, Node> map, Node cur, StringBuilder sb) {
        if(cur == null) {
            return sb;
        }
        getPostorder(map, cur.getLeft(), sb);
        getPostorder(map, cur.getRight(), sb);
        sb.append(cur.node);
        return sb;
    }
    
    public static void addLeft(Map<Character, Node> map, Node rootNode, char leftC) {
        Node left;
        if(!map.containsKey(leftC)) {
            left = new Node(leftC);
            left.setRoot(rootNode);
            rootNode.setLeft(left);
        } else {
            left = map.get(leftC);
            left.setRoot(rootNode);
            rootNode.setLeft(left);
        }

        map.put(left.node, left);
    }
    
    public static void addRight(Map<Character, Node> map, Node rootNode, char rightC) {
        Node right;
        if(!map.containsKey(rightC)) {
            right = new Node(rightC);
            right.setRoot(rootNode);
            rootNode.setRight(right);
        } else {
            right = map.get(rightC);
            right.setRoot(rootNode);
            rootNode.setRight(right);
        }

        map.put(right.node, right);
    }
    
    public static class Node {
        char node;
        Node root;
        Node left;
        Node right;
        
        public Node(char c) {
            this.node = c;
        }
        
        public void setRoot(Node root) {
            this.root = root;
        }
        
        public void setLeft(Node left) {
            this.left = left;
        }
        
        public void setRight(Node right) {
            this.right = right;
        }
        
        public Node getRoot() {
            return root;
        }
        
        public Node getLeft() {
            return left;
        }
        
        public Node getRight() {
            return right;
        }
        
    }
}