package stack;

import java.util.Stack;

public class StockSpanner {

    static Stack<Integer> index;
    static Stack<Integer> values;
    static int i = 0;

    public StockSpanner() {
        index = new Stack<>();
        values = new Stack<>();

        i -= 1;
    }

    public static int next(int price) {
        i++;

        while (!index.isEmpty() && (price >= values.peek())) {
            values.pop();
            index.pop();
        }

        if (index.isEmpty()) {
            index.push(i);
            values.push(price);

            return i + 1;
        } else {
            int prevMaxIndex = index.peek();
            index.push(i);
            values.push(price);

            return i - prevMaxIndex;
        }
    }

    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();

        /*System.out.println(next(100));

        System.out.println(next(80));

        System.out.println(next(60));

        System.out.println(next(70));

        System.out.println(next(60));

        System.out.println(next(75));
        System.out.println(next(85));*/


        System.out.println(next(28));

        System.out.println(next(14));

        System.out.println(next(28));

        System.out.println(next(35));

        System.out.println(next(46));

       /* System.out.println(next(53));

        System.out.println(next(66));

        System.out.println(next(80));

        System.out.println(next(87));

        System.out.println(next(88));*/


        /*System.out.println(next(31));
        System.out.println(next(41));
        System.out.println(next(48));
        System.out.println(next(59));
        System.out.println(next(79));*/
    }
}
