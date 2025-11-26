package Assignment_5;

import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList_Q1 {
    Node head;

    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    void insertBefore(int target, int data) {
        if (head == null) return;
        if (head.data == target) {
            insertAtBeginning(data);
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != target) temp = temp.next;
        if (temp.next == null) return;
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void insertAfter(int target, int data) {
        Node temp = head;
        while (temp != null && temp.data != target) temp = temp.next;
        if (temp == null) return;
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void deleteFromBeginning() {
        if (head != null) head = head.next;
    }

    void deleteFromEnd() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) temp = temp.next;
        temp.next = null;
    }

    void deleteSpecific(int target) {
        if (head == null) return;
        if (head.data == target) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != target) temp = temp.next;
        if (temp.next == null) return;
        temp.next = temp.next.next;
    }

    void search(int target) {
        Node temp = head;
        int pos = 1;
        while (temp != null) {
            if (temp.data == target) {
                System.out.println("Node " + target + " found at position " + pos);
                return;
            }
            temp = temp.next;
            pos++;
        }
        System.out.println("Node " + target + " not found");
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList_Q1 list = new SinglyLinkedList_Q1();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert Before");
            System.out.println("4. Insert After");
            System.out.println("5. Delete from Beginning");
            System.out.println("6. Delete from End");
            System.out.println("7. Delete Specific Node");
            System.out.println("8. Search");
            System.out.println("9. Display");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    list.insertAtBeginning(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter value: ");
                    list.insertAtEnd(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter target value: ");
                    int t1 = sc.nextInt();
                    System.out.print("Enter new value: ");
                    list.insertBefore(t1, sc.nextInt());
                    break;
                case 4:
                    System.out.print("Enter target value: ");
                    int t2 = sc.nextInt();
                    System.out.print("Enter new value: ");
                    list.insertAfter(t2, sc.nextInt());
                    break;
                case 5:
                    list.deleteFromBeginning();
                    break;
                case 6:
                    list.deleteFromEnd();
                    break;
                case 7:
                    System.out.print("Enter value to delete: ");
                    list.deleteSpecific(sc.nextInt());
                    break;
                case 8:
                    System.out.print("Enter value to search: ");
                    list.search(sc.nextInt());
                    break;
                case 9:
                    list.display();
                    break;
                case 10:
                    System.exit(0);
            }
        }
    }
}
