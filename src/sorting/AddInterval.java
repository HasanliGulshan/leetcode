package sorting;

import java.util.ArrayList;
import java.util.List;

class Interval {
    public int left, right;

    public Interval(int l, int r) {
        this.left = l;
        this.right = r;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}

public class AddInterval {
    public List<Interval> addlnterval(List<Interval> disjointlntervals, Interval newlnterval) {
        int i = 0;
        List<Interval> result = new ArrayList<>();
        // Processes intervals in disjointlntervals which come before newlnterval.
        while (i < disjointlntervals.size() && newlnterval.left > disjointlntervals.get(i).right) {
            result.add(disjointlntervals.get(i++));
        }

        // Processes intervals in disjointlntervals which overlap with newlnterval .
        while (i < disjointlntervals.size() && newlnterval.right >= disjointlntervals.get(i).left) {
            // If [a, b ] and [c , d] overlap, their union is [min(a , c),max(b, d) ] .
            newlnterval = new Interval(Math.min(newlnterval.left, disjointlntervals.get(i).left),
                    Math.max(newlnterval.right, disjointlntervals.get(i).right));
            ++i;
        }


        result.add(newlnterval);
        // Processes intervals in disjointlntervals which come after newlnterval .
        result.addAll(disjointlntervals.subList(i, disjointlntervals.size()));

        return result;
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(-4, -1);
        Interval i2 = new Interval(0, 2);
        Interval i3 = new Interval(3, 6);
        Interval i4 = new Interval(7, 9);
        Interval i5 = new Interval(11, 12);
        Interval i6 = new Interval(14, 17);

        Interval i = new Interval(1, 8);

        List<Interval> d = new ArrayList<>();
        d.add(i1);
        d.add(i2);
        d.add(i3);
        d.add(i4);
        d.add(i5);
        d.add(i6);

        System.out.println(new AddInterval().addlnterval(d, i));
    }
}