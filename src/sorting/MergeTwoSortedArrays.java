package sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedArrays {

    public static void mergeTwoSortedArrays(List<Integer> A, int m, List<Integer> B, int n) {
        int a = m - 1, b = n - 1, writeldx = m + n - 1;
        while (a >= 0 && b >= 0) {
            A.set(writeldx--, A.get(a) > B.get(b) ? A.get(a--) : B.get(b--));
        }
        while (b >= 0) {
            A.set(writeldx, B.get(b--));
        }

        System.out.println(A);
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>(8);

        a.add(5);
        a.add(13);
        a.add(17);
        a.add(18);

        a.add(20);

        a.add(null);
        a.add(null);
        a.add(null);

        a.add(null);

        List<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(7);
        b.add(11);
        b.add(19);

        mergeTwoSortedArrays(a, 5, b, 4);
    }
}
