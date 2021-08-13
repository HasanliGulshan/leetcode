package math;

public class RectangleOverlap {
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // min width is greater than max x
        //min height is greater than max y so in this case area will be positive and also overlaps
        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) && // width > 0
                Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));  // height > 0
    }

    public static void main(String[] args) {
      // int[]  rec1 = new int[]{ 0,0,2,2}, rec2 = new int[]{1,1,3,3};
        int[]  rec1 = new int[]{ 0,0,1,1}, rec2 = new int[]{1,0,2,1};
        System.out.println(isRectangleOverlap(rec1, rec2));
    }
}
