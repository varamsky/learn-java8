package org.example.BeforeJava8.Multithreading.MultithreadingWithStack;

public class StackRunner {
    public static void main(String[] args) {
        System.out.println("Main starts");

        ThreadUnsafeStack stack = new ThreadUnsafeStack(5);
//        ThreadSafeStack stack = new ThreadSafeStack(5);

        // checking normal execution
//        int counter = 0;
//        while (++counter < 5) System.out.println("Pushed: " + stack.push(100));
//
//        counter = 0;
//        while (++counter < 5) System.out.println("Popped: " + stack.pop());

        new Thread(()->{
            int counter = 0;
            while(++counter < 5) System.out.println("Pushed: " + stack.push(100));
        }, "Pusher").start();

        new Thread(()->{
            int counter = 0;
            while(++counter < 5) System.out.println("Popped: " + stack.pop());
        }, "Popper").start();

        System.out.println("Main exit");

    }
}
