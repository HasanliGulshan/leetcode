package arrays;

import java.util.ArrayList;
import java.util.List;

public class RotateMatrix {
    public static void rotateMatrix(List<List<Integer>> squareMatrix) {
        final int matrixSize = squareMatrix.size() - 1;

        for (int i = 0; i < (squareMatrix.size() / 2); ++i) {
            for (int j = i; j < matrixSize - i; ++j) {
                // Perform a 4-way exchange.
                int tempi = squareMatrix.get(matrixSize - j).get(i);
                int temp2 = squareMatrix.get(matrixSize - i).get(matrixSize - j);
                int temp3 = squareMatrix.get(j).get(matrixSize - i);
                int temp4 = squareMatrix.get(i).get(j);
                squareMatrix.get(i).set(j, tempi);
                squareMatrix.get(matrixSize - j).set(i, temp2);
                squareMatrix.get(matrixSize - i).set(matrixSize - j, temp3);
                squareMatrix.get(j).set(matrixSize - i, temp4);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item1 = new ArrayList<>();
        List<Integer> item2 = new ArrayList<>();
        List<Integer> item3 = new ArrayList<>();
        List<Integer> item4 = new ArrayList<>();

        item1.add(1);
        item1.add(2);
        item1.add(3);
        item1.add(4);

        res.add(item1);

        item2.add(5);
        item2.add(6);
        item2.add(7);
        item2.add(8);

        res.add(item2);


        item3.add(9);
        item3.add(10);
        item3.add(11);
        item3.add(12);

        res.add(item3);

        item4.add(13);
        item4.add(14);
        item4.add(15);
        item4.add(16);

        res.add(item4);

        rotateMatrix(res);

        System.out.println(res);
    }
}
