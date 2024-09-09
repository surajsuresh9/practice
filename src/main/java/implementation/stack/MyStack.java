package implementation.stack;

// LIFO (Last In First Out)
public class MyStack {
    int[] a;
    int tos;
    int maxSize;

    MyStack(int size) {
        // initialize Stack
        maxSize = size;
        a = new int[maxSize];
        tos = -1;
    }

    public boolean isFull() {
        if (tos == a.length - 1) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (tos == -1) {
            return true;
        }
        return false;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack overflow");
            return;
        }
        a[++tos] = data;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
        }
        return a[tos--];
    }

    public int peek() {
        return a[tos];
    }

    public void printStack() {
        String str = "Stack: [";
        for (int i = 0; i <= tos; i++) {
            str += a[i] + ", ";
        }
        str = str.substring(0, str.length() - 2);
        str += "]";
        System.out.println(str);
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack(5);
        System.out.println("isEmpty: " + stack.isEmpty());
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.printStack();
        System.out.println("isFull: " + stack.isFull());
        System.out.println("Element at top: " + stack.peek());
//        System.out.println(stack.pop() + " popped from stack");
//        stack.printStack();
    }
}
