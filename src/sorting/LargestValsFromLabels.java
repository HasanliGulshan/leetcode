package sorting;

import java.util.HashMap;
import java.util.PriorityQueue;

class Value {
    int value;
    int label;

    Value(int value, int label) {
        this.value = value;
        this.label = label;
    }
}

class Label{
    int totalCount;
    int useCount;

    Label(int count, int useCount) {
        this.totalCount = count;
        this.useCount = useCount;
    }
}

public class LargestValsFromLabels {
    public static int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        PriorityQueue<Value> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);

        HashMap<Integer, Label> map = new HashMap<>();

        for (int i = 0; i <values.length; i++) {
            priorityQueue.add(new Value(values[i], labels[i]));

            if (map.containsKey(labels[i])) {
                map.get(labels[i]).totalCount++;
            } else {
                map.put(labels[i], new Label(1, 0));
            }
        }

        int res = 0;

        while (!priorityQueue.isEmpty() && num_wanted > 0) {
            Value value = priorityQueue.poll();
            Label label = map.get(value.label);

            if (label.totalCount > 0 && label.useCount < use_limit) {
                label.totalCount--;
                label.useCount++;

                res += value.value;
                num_wanted--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        //values = [5,4,3,2,1], labels = [1,1,2,2,3], num_wanted = 3, use_limit = 1
        int[] v = new int[]{9,8,8,7,6};
        int[] l = new int[]{0,0,0,1,1};

        System.out.println(largestValsFromLabels(v, l, 3, 2));
    }

}
