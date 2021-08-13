package stack;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class CustomStack {

    class Item {
        int value;

        Item(int x) {
            this.value = x;
        }
    }

    final int maxSize;
    Deque<Item> deque = new LinkedList<>();

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if (deque.size() < maxSize)
            deque.push(new Item(x));
    }

    public int pop() {
        if (deque.isEmpty()) return -1;

        return deque.pop().value;
    }

    public void increment(int k, int val) {
        int countOfIncrements = Math.min(maxSize, k);
        int count = 0;

        for (Iterator iterator = deque.descendingIterator(); iterator.hasNext(); ) {
            if (count == countOfIncrements) break;

            Item elem = (Item) iterator.next();
            elem.value += val;

            count++;
        }
    }

    public static void main(String[] args) {
        CustomStack obj = new CustomStack(3);
        obj.push(1);
        obj.push(2);
        System.out.println(obj.pop());

        obj.push(3);
        obj.push(4);
        obj.push(5);
        obj.increment(5, 100);
        obj.increment(2, 100);

        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());

    }
}
