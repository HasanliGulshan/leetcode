package heap;

import java.util.PriorityQueue;

public class SeatManager {

    PriorityQueue<Integer> queue;
    int size = 0;

    public SeatManager(int n) {
        this.size = n;
        queue = new PriorityQueue<>(size);

        for (int i = 1; i <=n ; i++)
            queue.add(i);
    }

    public int reserve() {
        return !queue.isEmpty()? queue.poll() : -1;
    }

    public void unreserve(int seatNumber) {
        if (seatNumber <= size)
            queue.add(seatNumber);
    }

    public static void main(String[] args) {
        SeatManager obj = new SeatManager(5);
        System.out.println(obj.reserve());
        System.out.println(obj.reserve());
          obj.unreserve(2);
        System.out.println(obj.reserve());
        System.out.println(obj.reserve());
        System.out.println(obj.reserve());
        System.out.println(obj.reserve());
        obj.unreserve(5);

    }
}
