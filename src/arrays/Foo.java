package arrays;

public class Foo {
    public volatile boolean second = true;
    public volatile boolean third = true;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        second = false;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(second) {}
        // printSecond.run() outputs "second". Do not change or remove this line.

        printSecond.run();
        third = false;

    }

    public void third(Runnable printThird) throws InterruptedException {
        while(third) {}
        // printThird.run() outputs "third". Do not change or remove this line.

        printThird.run();
        second = false;

    }
}
