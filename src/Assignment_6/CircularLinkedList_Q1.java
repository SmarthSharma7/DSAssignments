package Assignment_6;

import java.util.Scanner;

class CircularLinkedList {

    class Node {
        int data;
        Node next;
        Node(int d) { data = d; }
    }

    private Node head = null;

    public void insertFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != head) temp = temp.next;
        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }

    public void insertLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != head) temp = temp.next;
        temp.next = newNode;
        newNode.next = head;
    }

    public void insertAfter(int key, int data) {
        if (head == null) return;
        Node temp = head;
        boolean first = true;
        while (temp != head || first) {
            first = false;
            if (temp.data == key) {
                Node newNode = new Node(data);
                newNode.next = temp.next;
                temp.next = newNode;
                return;
            }
            temp = temp.next;
        }
    }

    public void deleteNode(int key) {
        if (head == null) return;

        if (head.data == key) {
            if (head.next == head) {
                head = null;
                return;
            }
            Node last = head;
            while (last.next != head) last = last.next;
            head = head.next;
            last.next = head;
            return;
        }

        Node prev = head;
        Node curr = head.next;
        while (curr != head) {
            if (curr.data == key) {
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public boolean search(int key) {
        if (head == null) return false;
        Node temp = head;
        boolean first = true;
        while (temp != head || first) {
            first = false;
            if (temp.data == key) return true;
            temp = temp.next;
        }
        return false;
    }

    public void display() {
        if (head == null) return;
        Node temp = head;
        boolean first = true;
        while (temp != head || first) {
            first = false;
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class CircularLinkedList_Q1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CircularLinkedList list = new CircularLinkedList();

        while (true) {
            System.out.println("\n1 Insert First");
            System.out.println("2 Insert Last");
            System.out.println("3 Insert After");
            System.out.println("4 Delete Node");
            System.out.println("5 Search");
            System.out.println("6 Display");
            System.out.println("7 Exit");
            System.out.print("Choice: ");

            int ch = sc.nextInt();

            if (ch == 1) list.insertFirst(sc.nextInt());
            else if (ch == 2) list.insertLast(sc.nextInt());
            else if (ch == 3) {
                int key = sc.nextInt();
                int val = sc.nextInt();
                list.insertAfter(key, val);
            }
            else if (ch == 4) list.deleteNode(sc.nextInt());
            else if (ch == 5) System.out.println(list.search(sc.nextInt()) ? "Found" : "Not Found");
            else if (ch == 6) list.display();
            else if (ch == 7) return;
        }
    }
}
