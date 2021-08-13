package stack;

import java.util.Deque;
import java.util.LinkedList;

class ElementWithCachedMax {
    public Integer element;
    public Integer max;

    public ElementWithCachedMax(Integer element, Integer max) {
        this.element = element;
        this.max = max;
    }
}

public class Stack {
    //each method has O(1) T.C

    // Stores (element , cached maximum) pair.
    private static Deque<ElementWithCachedMax> elementWithCachedMax
            = new LinkedList<>();

    public static boolean empty() {
        return elementWithCachedMax.isEmpty();
    }

    public static Integer max() {
        if (empty()) {
            throw new IllegalStateException("max(): empty stack");
        }
        return elementWithCachedMax.peek().max;
    }

    public static Integer pop() {
        if (empty()) {
            throw new IllegalStateException("pop(): empty stack");
        }
        return elementWithCachedMax.removeFirst().element;
    }

    public static void push(Integer x) {
        elementWithCachedMax.addFirst(
                new ElementWithCachedMax(x, Math.max(x, empty() ? x : max())));
    }


    public static void main(String[] args) {
        push(20);
        System.out.println(max());
        push(10);

        push(30);
        push(15);
        pop();
        pop();
        System.out.println(max());
        push(50);
        System.out.println(max());
    }
}
