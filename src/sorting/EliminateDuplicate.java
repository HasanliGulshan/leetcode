package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Name implements Comparable <Name> {
    String firstName;
    String lastName ;

    Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int compareTo(Name name) {
        int cmpFirst = firstName.compareTo(name.firstName);
        if (cmpFirst != 0) {
            return cmpFirst;

        }
        return lastName.compareTo(name.lastName);
    }
}
public class EliminateDuplicate {
    public static void eliminateDuplicate(List<Name> A) {
        Collections.sort(A); // Makes identical elements become neighbors.
        int result = 0;
        for (int first = 1; first < A.size(); first++) {
            if (!A.get(first).firstName.equals(A.get(result).firstName)) {
                A.set(++result, A.get(first));
            }
        }
        for (Name name : A) {
            System.out.print(name.firstName + " " + name.lastName+" ");
        }

        System.out.println();
// Shrinks array size.
        A.subList(++result, A.size()).clear();

        for (Name name : A) {
            System.out.print(name.firstName + " " + name.lastName+" ");
        }
    }

    public static void main(String[] args) {
        Name name = new Name("Ian","Botham" );

        Name name2 = new Name("Ian","Bell");

        Name name3 = new Name("Ian","Chappell");

        Name name4 = new Name("David","Gower");

        List<Name> list = new ArrayList<>();

        list.add(name);
        list.add(name2);
        list.add(name3);
        list.add(name4);

        eliminateDuplicate(list);
    }
}
