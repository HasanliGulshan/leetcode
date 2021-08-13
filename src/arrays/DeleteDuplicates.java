package arrays;

import java.util.ArrayList;
import java.util.List;

public class DeleteDuplicates {

    // .Returns the number of valid entries after deletion.
    public static int deleteDuplicates(List<Integer> A) {
        //recall that list is sorted when given
        if (A.isEmpty()) {
            return 0;
        }
        int writelndex = 1;
        for (int i = 1; i < A.size(); ++i) {
            if (!A.get(writelndex - 1).equals(A.get(i))) {
                A.set(writelndex++, A.get(i));
            }
        }
        return writelndex;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(2);
        list.add(5);
        list.add(6);
        list.add(6);
        System.out.println(deleteDuplicates(list));
    }
}
