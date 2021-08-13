package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomSampling {
    public static void randomSampling(int k, List<Integer> A) {
        Random gen = new Random();
        for (int i = 0; i < k; ++i) {
           // Generate a random int in [i, A.size() - 1].
            Collections.swap(A, i, i + gen.nextInt(A.size() - i));
        }

        for (int i : A) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(3); l.add(7); l.add(5); l.add(11);
        randomSampling(3, l);
    }
}
