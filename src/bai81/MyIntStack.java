package bai81;

public class MyIntStack {
    private int[] contents;
    private int tos; // Top of the stack

    // Constructor
    public MyIntStack(int capacity) {
        contents = new int[capacity];
        tos = -1;
    }

    // Push method with exception handling and dynamic resizing
    public boolean push(int element) {
        if (isFull()) {
            // Resize the array dynamically
            int newSize = contents.length * 2;
            int[] newContents = new int[newSize];
            System.arraycopy(contents, 0, newContents, 0, contents.length);
            contents = newContents;
        }
        contents[++tos] = element;
        return true;
    }

    // Pop method
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }
        return contents[tos--];
    }

    // Peek method
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }
        return contents[tos];
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return tos < 0;
    }

    // Check if stack is full
    public boolean isFull() {
        return tos == contents.length - 1;
    }
}
