package heap;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class ValueWithRank {
    public Integer value ;
    public Integer rank;

    private int timestamp = 0;
    private PriorityQueue<ValueWithRank> maxHeap = new PriorityQueue <>(
            DEFAULT_INITIAL_CAPACITY , Compare.COMPARE_VALUE_WITH_RANK);

    public ValueWithRank(Integer value, Integer rank) {
        this.value = value;
        this.rank = rank;
    }

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    private static class Compare implements Comparator<ValueWithRank> {
        @Override
        public int compare(ValueWithRank ol, ValueWithRank o2) {
            return Integer.compare(o2.rank , ol.rank);
        }
        public static final Compare COMPARE_VALUE_WITH_RANK = new Compare();
    }

    public void push(Integer x) {
        maxHeap.add(new ValueWithRank(x , timestamp++));
    }
    public Integer pop() throws NoSuchElementException {
        return maxHeap.remove().value ;
    }
    public Integer peek() { return maxHeap.peek().value ; }
}
