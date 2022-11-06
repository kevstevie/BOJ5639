import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Tree t = new Tree();

        int root = Integer.parseInt(br.readLine());
        t.root = new Node(root);
        String line;
        while ((line = br.readLine()) != null) {
            int num = Integer.parseInt(line);
            t.addNode(t.root, num);
        }
        t.postOrder(t.root);
        System.out.println(t.sb);
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}

class Tree {
    Node root;
    StringBuilder sb = new StringBuilder();
    void addNode(Node root, int data) {
        if (data> root.data) {
            if (root.right == null) {
                root.right = new Node(data);
            } else {
                addNode(root.right, data);
            }
        } else {
            if (root.left == null) {
                root.left = new Node(data);
            } else {
                addNode(root.left, data);
            }
        }
    }
    void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            sb.append(root.data).append(" ");
        }
    }
}