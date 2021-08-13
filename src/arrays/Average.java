package arrays;

import java.util.Arrays;

public class Average {
    public double average(int[] salary) {
        Arrays.sort(salary);
        double average = 0;

        for (int i = 1; i < salary.length - 1; i++) {
            average += salary[i];
        }

        return average/(salary.length - 2);
    }

    public static void main(String[] args) {

    }
}
