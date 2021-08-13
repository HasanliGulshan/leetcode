package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Queue2 {
    private Deque<Integer> deq;
    private Deque<Integer> enq;

    Queue2() {
        deq = new ArrayDeque<>();
        enq = new ArrayDeque<>();
    }

    public void push(int x) {
        enq.addFirst(x);
    }

    public int pop() {
        if (deq.isEmpty()) {
            while (!enq.isEmpty()) {
                deq.addFirst(enq.removeFirst());
            }
        }

        return deq.removeFirst();
    }

    public int peek() {
        if (deq.isEmpty()) {
            while (!enq.isEmpty()) {
                deq.addFirst(enq.removeFirst());
            }

        }

        if (deq.peekFirst() != null)
            return deq.peekFirst();

        return 0;
    }

    public boolean empty() {
        return deq.isEmpty() && enq.isEmpty();
    }

    public static void main(String[] args) {
        Queue2 obj = new Queue2();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        System.out.println("1: " + obj.pop());

        obj.push(5);
        System.out.println("2: " +obj.pop());

        System.out.println("3: " + obj.pop());
        System.out.println(obj.pop());

        System.out.println("4: " + obj.pop());
    }
}
