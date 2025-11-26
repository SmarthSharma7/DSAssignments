package Assignment_5;

public class ReverseLinkedList_Q4 {
    public static void main(String[] args) {
        SinglyLinkedList_Q1 list = new SinglyLinkedList_Q1(); // This is made by me in this package
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);

        System.out.println("Before reversal : ");
        list.display();

        list.head = reverse(list.head);

        System.out.println("After reversal : ");
        list.display();
    }

    static Node reverse(Node head) {
        Node prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
}
