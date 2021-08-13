package arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class OnlineRandomSample {
    // Assumption: there are at least k elements in the stream.
    public static List<Integer> onlineRandomSample(Iterator<Integer> sequence,
                                                   int k) {
        List<Integer> runningSample = new ArrayList<>(k);
        // Stores the first k elements.
        for (int i = 0; sequence.hasNext() && i < k; ++i) {
            runningSample.add(sequence.next());
        }
        // Have read the first k elements.
        int numSeenSoFar = k;
        Random randldxGen = new Random();
        while (sequence.hasNext()) {
            Integer x = sequence.next();
            ++numSeenSoFar;
            // Generate a random number in [0, numSeenSoFar], and if this number is in
            // [0, k - 1], we replace that element from the sample with x.
            final int idxToReplace = randldxGen.nextInt(numSeenSoFar);
            if (idxToReplace < k) {
                //runningSample has k length so we check if it is lesser than k  avoid IndexOutOfBoundException
                runningSample.set(idxToReplace, x);
            }
        }
        return runningSample;
    }

    public static void main(String[] args) {
        List<Integer> sequence = new ArrayList<>();

        sequence.add(2); sequence.add(3); sequence.add(4);
        sequence.add(5); sequence.add(12); sequence.add(45);

        List<Integer> s = onlineRandomSample(sequence.iterator(), 2);

        for (int k : s) System.out.print(k + " ");
    }
}
