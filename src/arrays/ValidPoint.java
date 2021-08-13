package arrays;

public class ValidPoint {
    public static int nearestValidPoint(int x, int y, int[][] points) {
        int index = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][0] == y) {
                int temp = distance(x, y, points[i][0], points[i][0]);

                if (temp < min) {
                    min = temp;
                    index = i;
                }
            }
        }

        return index;
    }

    public static int distance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
