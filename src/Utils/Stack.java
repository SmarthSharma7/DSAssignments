
package Utils;

public class Stack {

    private final int MAX = 100;
    private int top;
    private char[] arr;

    public Stack() {
        top = -1;
        arr = new char[MAX];
    }

    public void push(char x) {
        if (isFull()) {
            System.out.println("Stack overflow");
            return;
        }
        top++;
        arr[top] = x;
    }

    public char pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return 0;
        }
        System.out.println("Popping " + arr[top] + " from top of stack");
        top--;
        return arr[top + 1];
    }

    public char peek() {
        return arr[top];
    }

    public void display() {
        if (!isEmpty()) {
            for (int i = top; i >= 0; i--) {
                System.out.print(arr[i] + "\n");
            }
        } else System.out.println("Stack underflow");
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == MAX - 1;
    }
}
