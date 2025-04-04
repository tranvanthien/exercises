package bai81;

public class TestMyIntStack {
    public static void main(String[] args) {

        MyIntStack stack = new MyIntStack(3);


        System.out.println("Stack is empty? " + stack.isEmpty());


        System.out.println("Pushing 10: " + stack.push(10));
        System.out.println("Pushing 20: " + stack.push(20));
        System.out.println("Pushing 30: " + stack.push(30));


        System.out.println("Pushing 40 (should trigger resize): " + stack.push(40));


        System.out.println("Top element (peek): " + stack.peek());


        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());


        System.out.println("Stack is empty? " + stack.isEmpty());

        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        try {
            System.out.println("Attempting to pop from empty stack...");
            System.out.println("Popped: " + stack.pop());
        } catch (IllegalStateException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
