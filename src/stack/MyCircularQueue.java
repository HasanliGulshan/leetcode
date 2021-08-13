package stack;

public class MyCircularQueue {
    int[] nums = null;
    int elementsOfQueue = -1;

    public MyCircularQueue(int k) {
        nums = new int[k];
    }

    public boolean enQueue(int value) {
        if (elementsOfQueue < nums.length - 1) {
            elementsOfQueue++;
            nums[elementsOfQueue] = value;

            return true;
        }
        return false;
    }

    public boolean deQueue() {
       if (!isEmpty()) {

           for (int i = 0, j = 1; j < nums.length; i++, j++) {
               nums[i] = nums[j];
           }

           elementsOfQueue--;
           return true;
       }

       return false;
    }

    //get first element
    public int Front() {
        if (!isEmpty()) {
            return nums[0];
        }
        return -1;
    }

    //get last element
    public int Rear() {
        if (!isEmpty() && elementsOfQueue < nums.length) {
            return nums[elementsOfQueue];
        }
        return -1;
    }

    public boolean isEmpty() {
        return elementsOfQueue == -1;
    }

    public boolean isFull() {
        return elementsOfQueue == nums.length - 1;
    }

    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(3);
        System.out.println(obj.enQueue(1));
        System.out.println(obj.enQueue(2));

        System.out.println(obj.enQueue(3));
        System.out.println(obj.enQueue(4));
        System.out.println(obj.Rear());
        System.out.println(obj.isFull());
        System.out.println(obj.deQueue());
        System.out.println(obj.Rear());
        System.out.println(obj.deQueue());
        System.out.println(obj.Rear());

        System.out.println(obj.deQueue());
        System.out.println(obj.Rear());
        System.out.println(obj.enQueue(4));
        System.out.println(obj.Rear());

       /* System.out.println(obj.Front());




        System.out.println(obj.Front());
        System.out.println(obj.Rear());

        System.out.println(obj.deQueue());
        System.out.println(obj.Front());
        System.out.println(obj.Rear());

        System.out.println(obj.isEmpty());*/

    }
}
