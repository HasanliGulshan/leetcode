package stack;

import java.util.Iterator;
import java.util.Stack;

public class MinStack {
    static Stack<Integer> stack;
    int minElement;

    public MinStack() {
        stack = new Stack<>();
        minElement = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x < minElement) {
            stack.push(minElement);
            minElement = x;
        }

        System.out.println(" in  push x = " + x + " mm" + minElement);

        stack.push(x);
    }

    public void pop() {
       if (minElement == stack.pop()) {
           minElement = stack.pop();
       }

    }

    public int top() {
       return stack.peek();
    }

    public int getMin() {
       return minElement;
    }

    public static void main(String[] args) {
        System.out.println("From : ");
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);



        System.out.println("min element" + minStack.getMin());
        minStack.pop();
        System.out.println("top " + minStack.top());

        System.out.println("min " + minStack.getMin());

        Iterator value = stack.iterator();

        while(value.hasNext()){
            System.out.println(value.next());
        }
    }
}
