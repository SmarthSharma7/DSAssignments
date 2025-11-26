package Assignment_6;

import java.util.Scanner;

class DoublyLinkedList {

    class Node {
        int data;
        Node next, prev;
        Node(int d) { data = d; }
    }

    private Node head;

    public void insertFirst(int data) {
        Node n = new Node(data);
        n.next = head;
        if (head != null) head.prev = n;
        head = n;
    }

    public void insertLast(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
            return;
        }
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = n;
        n.prev = temp;
    }

    public void insertAfter(int key, int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                Node n = new Node(data);
                n.next = temp.next;
                n.prev = temp;
                if (temp.next != null) temp.next.prev = n;
                temp.next = n;
                return;
            }
            temp = temp.next;
        }
    }

    public void deleteNode(int key) {
        if (head == null) return;
        Node temp = head;
        while (temp != null && temp.data != key) temp = temp.next;

        if (temp == null) return;

        if (temp.prev != null) temp.prev.next = temp.next;
        else head = temp.next;

        if (temp.next != null) temp.next.prev = temp.prev;
    }

    public boolean search(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) return true;
            temp = temp.next;
        }
        return false;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class DoublyLinkedList_Q1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();

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

