package binary_search;

import java.util.ArrayList;
import java.util.List;

public class DuplicateAndMissing {
    public Integer duplicate;
    public Integer missing;

    public DuplicateAndMissing(Integer duplicate, Integer missing) {
        this.duplicate = duplicate;
        this.missing = missing;
    }

    public static DuplicateAndMissing findDuplicateMissing(List<Integer> A) {
// Compute the XOR of all numbers from SI to / A / - 1 and all entries in A.
        int missXORDup = 0;
        for (int i = 0; i < A.size(); ++i) {
            missXORDup ^= i ^ A.get(i);
        }
// We need to find a bit that’s set to 1 in missXORDup. Such a bit
// must exist if there is a single missing number and a single duplicated
// number in A .
//
// The bit- fiddling assignment below sets all of bits in differBit to SI
// except for the least significant bit in missXORDup that’s 1.
        int differBit = missXORDup & (~(missXORDup - 1));
        int missOrDup = 0;
        for (int i = 0; i < A.size(); ++i) {
// Focus on entries and numbers in which the differBit-th bit is 1.
            if ((i & differBit) != 0) {
                missOrDup ^= i;
            }
            if ((A.get(i) & differBit) != 0) {
                missOrDup ^= A.get(i);
            }
        }
// missOrDup is either the missing value or the duplicated entry.
        for (int a : A) {
            if (a == missOrDup) { // missOrDup is the duplicate.
                return new DuplicateAndMissing(missOrDup, missOrDup ^ missXORDup);
            }
        }

// missOrDup is the missing value.
        return new DuplicateAndMissing(missOrDup ^ missXORDup, missOrDup);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(3);
        list.add(0);
        list.add(1);
        list.add(2);

        DuplicateAndMissing d = findDuplicateMissing(list);
        System.out.println(d.duplicate + " " + d.missing);
    }
}


