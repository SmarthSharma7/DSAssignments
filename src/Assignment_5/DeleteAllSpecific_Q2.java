package Assignment_5;

public class DeleteAllSpecific_Q2 {
    public static void main(String[] args) {
        SinglyLinkedList_Q1 list = new SinglyLinkedList_Q1(); // This is made by me in this package
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(1);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(1);

        System.out.println("Before removing all instances of 1 : ");
        list.display();

        Node temp = list.head;
        while (temp != null) {
            if (temp.data == 1) list.deleteSpecific(1);
            temp = temp.next;
        }

        System.out.println("After removing all instances of 1 : ");
        list.display();

    }
}
