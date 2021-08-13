package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntersectTwoSortedArrays {

    //t.c O(m*n)
    /*public static List<Integer> intersectTwoSortedArrays(List<Integer> A,
                                                         List<Integer> B) {
        List<Integer> intersectionAB = new ArrayList<>();
        for (int i = 0; i<A.size() ; ++i){
            if (i == 0 ||A.get(i) != A.get(i - 1)){
                for (Integer b : B) {
                    if (A.get(i).equals(b)) {
                        intersectionAB.add(A.get(i));
                        break;
                    }
                }
            }
        }
        return intersectionAB;
    }*/

    //t.c O(m*log(n)) binary search  can choose outer loop shorter array to improve t.c n < m O(n*log(m))
    /*public static List<Integer> intersectTwoSortedArrays(List<Integer> A, List<Integer> B) {
        List<Integer > intersectionAB = new ArrayList<>();
        for (int i = 0; i<A.size(); ++i){
            if ((i == 0 || A.get(i) != A.get(i - 1)) && Collections.binarySearch(B, A.get(i)) >= 0){
                intersectionAB.add(A.get(i));
            }
        }
        return intersectionAB;
    }*/

    //t.c O(m+n)
    public static List <Integer> intersectTwoSortedArrays (List <Integer> A, List <Integer> B) {
        List<Integer> intersectionAB = new ArrayList<>();
        int i = 0 ,j = 0;
        while (i < A.size() && j < B.size()) {
            if (A.get(i).equals(B.get(j)) && (i == 0 || !A.get(i).equals(A.get(i - 1)))){
                intersectionAB.add(A.get(i));
                ++i;
                ++j;
            } else if (A.get(i) < B.get(j)) {
                ++i;
            } else { // A.get(i) > B.get(j).
                ++j;
            }
        }
        return intersectionAB;
    }
}
