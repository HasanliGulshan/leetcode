package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    private Deque<Integer> deque;

    public NestedIterator(List<NestedInteger> nestedList) {
        deque = new ArrayDeque<>();
        getIntegers(nestedList);
    }

    void getIntegers(List<NestedInteger> nestedList) {

        for (int i = 0; i < nestedList.size(); i++) {
            if (nestedList.get(i).isInteger()) {
                deque.addFirst(nestedList.get(i).getInteger());
            } else {
                getIntegers(nestedList.get(i).getList());
            }
        }
    }

    @Override
    public Integer next() {
       return deque.removeLast();
    }

    @Override
    public boolean hasNext() {
       return !deque.isEmpty();
    }

    public static void main(String[] args) {

    }
}
