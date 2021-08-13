package heap;

import java.util.*;

public class ArrayEntry {
    public Integer value;
    public Integer arrayld;

    public ArrayEntry(Integer value, Integer arrayld) {
        this.value = value;
        this.arrayld = arrayld;
    }

    public static List<Integer> mergeSortedArrays(List<List<Integer>> sortedArrays) {
        List<Iterator<Integer>> iters = new ArrayList<>(sortedArrays.size());
        for (List<Integer> array : sortedArrays) {
            iters.add(array.iterator());
        }
        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(
                                          ((int) sortedArrays.size()), Comparator.comparingInt(ol -> ol.value));

        for (int i = 0; i < iters.size(); ++i) {
            if (iters.get(i).hasNext()) {
                minHeap.add(new ArrayEntry(iters.get(i).next(), i));
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            ArrayEntry headEntry = minHeap.poll();
            result.add(headEntry.value);
            if (iters.get(headEntry.arrayld).hasNext()) {
                minHeap.add(new ArrayEntry(iters.get(headEntry.arrayld).next(),
                        headEntry.arrayld));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(57);
        list.add(131);
        list.add(493);

        List<Integer> list1 = new ArrayList<>();
        list1.add(221);
        list1.add(294);

        List<Integer> list2 = new ArrayList<>();
        list2.add(339);
        list2.add(418);
        list2.add(452);

        List<Integer> list3 = new ArrayList<>();
        list3.add(190);
        list3.add(442);


        List<List<Integer>> req = new ArrayList<>();

        req.add(list);
        req.add(list1);
        req.add(list2);
        req.add(list3);
        System.out.println(mergeSortedArrays(req));
    }
}
