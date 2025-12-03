package Assignment_8;

public class CheckBST_Q4 {

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static boolean isBST(Node root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean isBSTUtil(Node node, int min, int max) {
        if (node == null) return true;

        if (node.data <= min || node.data >= max)
            return false;

        return isBSTUtil(node.left, min, node.data) &&
                isBSTUtil(node.right, node.data, max);
    }

    public static void main(String[] args) {

        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        if (isBST(root))
            System.out.println("The given tree IS a BST.");
        else
            System.out.println("The given tree is NOT a BST.");
    }
}
