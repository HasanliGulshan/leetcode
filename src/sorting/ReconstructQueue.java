package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
        });

        List<int[]> list = new ArrayList<>();
        for(int[] human: people) list.add(human[1], human);

        return list.toArray(new int[list.size()][]);
    }
}
