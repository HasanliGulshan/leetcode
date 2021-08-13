package arrays;

public class DiagonalSum {
    public static int diagonalSum(int[][] mat) {
       int ans = 0;

       for (int i = 0; i < mat.length; i++) {
           ans += mat[i][i] + mat[i][mat.length - i - 1];
       }

       if (ans % 2 == 0)
           return ans;

       return ans -= mat[mat.length/2][mat.length/2];
    }

    public static void main(String[] args) {

    }
}
