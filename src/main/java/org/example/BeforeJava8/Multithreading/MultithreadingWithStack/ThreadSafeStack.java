package org.example.BeforeJava8.Multithreading.MultithreadingWithStack;

public class ThreadSafeStack {

    // store elements of stack
    private int arr[];
    // represent top of stack
    private int top;
    // total capacity of the stack
    private final int capacity;

    // Creating a stack
    ThreadSafeStack(int size) {
        // initialize the array
        // initialize the stack variables
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    // push elements to the top of stack
    public synchronized int push(int x) {
        if (isFull()) {
            System.out.println("ERROR: Stack OverFlow");

            // terminates the program
            System.exit(1);
        }

        try {
            Thread.sleep(1000);
        }catch (Exception ignored){}

        // insert element on top of stack
        arr[++top] = x;
        return x;
    }

    // pop elements from top of stack
    public synchronized int pop() {
        // if stack is empty
        // no element to pop
        if (isEmpty()) {
            System.out.println("ERROR: STACK EMPTY");
            // terminates the program
            System.exit(1);
        }

        try {
            Thread.sleep(1000);
        }catch (Exception ignored){}

        // pop element from top of stack
        return arr[top--];
    }

    // return size of the stack
    public int getSize() {
        return top + 1;
    }

    // check if the stack is empty
    public Boolean isEmpty() {
        return top == -1;
    }

    // check if the stack is full
    public Boolean isFull() {
        return top == capacity - 1;
    }

    // display elements of stack
    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + ", ");
        }
    }
}