import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        Node root = new Node(Integer.parseInt(br.readLine()));

        while ((line = br.readLine()) != null) {
            if(line.isEmpty()) break;
            root.insert(Integer.parseInt(line));
        }

        getNums(root);

        System.out.println(sb.toString());

    }

    static StringBuilder sb = new StringBuilder();

    public static void getNums(Node cur) {
        if(cur == null) return;
        getNums(cur.left);
        getNums(cur.right);
        sb.append(cur.num).append("\n");
    }


    public static class Node {
        int num;
        Node left;
        Node right;

        Node() {}

        Node(int num) {
            this.num = num;
        }

        void insert(int n) {
            if (n < this.num) {
                if (this.left == null)
                    this.left = new Node(n);
                else this.left.insert(n);
            } else {
                if (this.right == null)
                    this.right = new Node(n);
                else this.right.insert(n);
            }
        }
    }
}