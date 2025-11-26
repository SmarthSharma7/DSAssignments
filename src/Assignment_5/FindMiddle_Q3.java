package Assignment_5;

public class FindMiddle_Q3 {
    public static void main(String[] args) {
        SinglyLinkedList_Q1 list = new  SinglyLinkedList_Q1(); // This is made by me in this package
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        findMiddle(list.head);
    }

    static void findMiddle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle element = " + slow.data);
    }
}
