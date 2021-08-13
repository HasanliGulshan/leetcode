package stack;

import java.util.Stack;

public class MyStack {
    Stack<Integer> stack;

    public MyStack() {
       stack = new Stack();
    }

    /** Push element x onto stack. */
    public void push(int x) {
       stack.push(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
       return stack.pop();
    }

    /** Get the top element. */
    public int top() {
        return stack.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.top());
        System.out.println(myStack.empty());
    }
}
