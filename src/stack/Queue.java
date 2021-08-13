package stack;

import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

public class Queue {
    private int head = 0, tail = 0, numQueueElements = 0;
    private static final int SCALE_FACTOR = 2;
    private Integer[] entries;

    public Queue(int capacity) {
        entries = new Integer[capacity];
    }

    public void enqueue(Integer x) {
        if (numQueueElements == entries.length) { // Need to resize.
            // Makes the queue elements appear consecutively.
            Collections.rotate(Arrays.asList(entries), -head);
            // Resets head and tail.
            head = 0;
            tail = numQueueElements;
            entries = Arrays.copyOf(entries, numQueueElements * SCALE_FACTOR);
        }
        entries[tail] = x;
        tail = (tail + 1) % entries.length;
        ++numQueueElements;
    }

    public Integer dequeue() {
        if (numQueueElements != 0) {
            --numQueueElements;
            Integer ret = entries[head];
            head = (head + 1) % entries.length;
            return ret;
        }
        throw new NoSuchElementException("Dequeue called on an empty queue.");
    }

    public int size() {
        return numQueueElements;
    }

    public static void main(String[] args) {
        Queue obj = new Queue(3);
        obj.enqueue(1);
        obj.enqueue(2);
        obj.enqueue(55);

        obj.enqueue(66);
        System.out.println(obj.dequeue());
        System.out.println(obj.dequeue());

        obj.enqueue(33);
        obj.enqueue(10);
        obj.dequeue();
        obj.dequeue();
        obj.dequeue();

        obj.enqueue(110);
        obj.enqueue(220);
        obj.enqueue(550);

        obj.dequeue();

    }
}
