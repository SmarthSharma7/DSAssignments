package Assignment_8;

public class BinaryTreeTraversal_Q1 {

    static class Node {
        int data;
        Node left, right;
        Node(int d) { data = d; left = right = null; }
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        System.out.print("Pre-order: ");
        preOrder(root);
        System.out.println();

        System.out.print("In-order: ");
        inOrder(root);
        System.out.println();

        System.out.print("Post-order: ");
        postOrder(root);
        System.out.println();
    }

    static void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }
}