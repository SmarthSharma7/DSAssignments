
package Assignment_3;

import java.util.Scanner;

public class StackMenu_Q1 {
    public static void main(String[] args) {

        Utils.Stack s = new Utils.Stack(); /* This class has all the functions implemented and is made by me in package
        "Utils" */
        Scanner sc = new Scanner(System.in);

        int choice;
        while (true) {
            System.out.println("----- Assignment_3.Stack Menu -----");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Check if empty");
            System.out.println("6. Check if full");
            System.out.println("7. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the character to push (characters following the first one will be " +
                            "ignored) : ");
                    char x = sc.next().charAt(0);
                    s.push(x);
                    break;
                case 2:
                    s.pop();
                    break;
                case 3:
                    if (!s.isEmpty()) System.out.println("Peeking " + s.peek());
                    break;
                case 4:
                    s.display();
                    break;
                case 5:
                    boolean isEmpty = s.isEmpty();
                    if(isEmpty) System.out.println("Stack is empty");
                    else System.out.println("Stack is not empty");
                    break;
                case 6:
                    boolean isFull = s.isFull();
                    if(isFull) System.out.println("Stack is full");
                    else System.out.println("Stack is not full");
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }

    }

}
