package Assignment_8;

public class BSTFunctions_Q2 {

    static class Node {
        int data;
        Node left, right;
        Node(int d) { data = d; left = right = null; }
    }

    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 70);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 60);
        root = insert(root, 80);

        System.out.println("Recursive search 40: " + (searchRecursive(root, 40) != null));
        System.out.println("Non-Recursive search 90: " + (searchIterative(root, 90) != null));
        System.out.println("Maximum element: " + maxElement(root).data);
        System.out.println("Minimum element: " + minElement(root).data);

        Node target = root.left; // 30
        Node successor = inOrderSuccessor(root, target);
        System.out.println("In-order successor of " + target.data + ": " + (successor != null ? successor.data : "None"));

        Node predecessor = inOrderPredecessor(root, target);
        System.out.println("In-order predecessor of " + target.data + ": " + (predecessor != null ? predecessor.data : "None"));
    }

    public static Node insert(Node root, int key) {
        if (root == null) return new Node(key);
        if (key < root.data) root.left = insert(root.left, key);
        else if (key > root.data) root.right = insert(root.right, key);
        return root;
    }

    public static Node searchRecursive(Node root, int key) {
        if (root == null || root.data == key) return root;
        if (key < root.data) return searchRecursive(root.left, key);
        return searchRecursive(root.right, key);
    }

    public static Node searchIterative(Node root, int key) {
        Node current = root;
        while (current != null) {
            if (current.data == key) return current;
            if (key < current.data) current = current.left;
            else current = current.right;
        }
        return null;
    }

    public static Node maxElement(Node root) {
        if (root == null) return null;
        Node current = root;
        while (current.right != null) current = current.right;
        return current;
    }

    public static Node minElement(Node root) {
        if (root == null) return null;
        Node current = root;
        while (current.left != null) current = current.left;
        return current;
    }

    public static Node inOrderSuccessor(Node root, Node target) {
        if (target.right != null) return minElement(target.right);
        Node successor = null;
        Node current = root;
        while (current != null) {
            if (target.data < current.data) {
                successor = current;
                current = current.left;
            } else if (target.data > current.data) current = current.right;
            else break;
        }
        return successor;
    }

    public static Node inOrderPredecessor(Node root, Node target) {
        if (target.left != null) return maxElement(target.left);
        Node predecessor = null;
        Node current = root;
        while (current != null) {
            if (target.data > current.data) {
                predecessor = current;
                current = current.right;
            } else if (target.data < current.data) current = current.left;
            else break;
        }
        return predecessor;
    }
}

