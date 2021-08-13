package arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static List<List<Integer>> generatePascalTriangle(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> currTriangle = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                currTriangle.add((j == 0 || j == i)
                        ?
                        1 :
                        pascalTriangle.get(i - 1).get(j - 1) + pascalTriangle.get(i - 1).get(j));
            }
            pascalTriangle.add(currTriangle);
        }

        System.out.println(pascalTriangle);
        return pascalTriangle;
    }

    public static void main(String[] args) {
        generatePascalTriangle(1);
    }
}
