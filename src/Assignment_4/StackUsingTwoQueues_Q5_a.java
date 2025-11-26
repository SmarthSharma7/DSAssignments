package Assignment_4;

class StackUsingTwoQueues {
    Queuee q1 = new Queuee();
    Queuee q2 = new Queuee();

    void push(int x) {
        q2.enqueue(x);
        while (!q1.isEmpty()) {
            q2.enqueue(q1.dequeue());
        }
        Queuee temp = q1;
        q1 = q2;
        q2 = temp;
    }

    int pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return q1.dequeue();
    }

    int top() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q1.peek();
    }

    boolean isEmpty() {
        return q1.isEmpty();
    }

    void display() {
        q1.display();
    }
}

public class StackUsingTwoQueues_Q5_a {
    public static void main(String[] args) {
        StackUsingTwoQueues stack = new StackUsingTwoQueues();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();

        System.out.println("Popped: " + stack.pop());
        System.out.println("Top: " + stack.top());
        stack.display();
    }
}
