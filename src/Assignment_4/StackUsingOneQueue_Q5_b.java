package Assignment_4;

class StackUsingOneQueue {
    Queuee q = new Queuee();

    void push(int x) {
        int size = q.size();
        q.enqueue(x);
        for (int i = 0; i < size; i++) {
            q.enqueue(q.dequeue());
        }
    }

    int pop() {
        if (q.isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return q.dequeue();
    }

    int top() {
        if (q.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q.peek();
    }

    boolean isEmpty() {
        return q.isEmpty();
    }

    void display() {
        q.display();
    }
}

public class StackUsingOneQueue_Q5_b {
    public static void main(String[] args) {
        StackUsingOneQueue stack = new StackUsingOneQueue();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();

        System.out.println("Popped: " + stack.pop());
        System.out.println("Top: " + stack.top());
        stack.display();
    }
}
