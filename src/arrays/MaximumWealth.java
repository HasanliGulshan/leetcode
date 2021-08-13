package arrays;

public class MaximumWealth {

    public static int maximumWealth(int[][] accounts) {
       int maxWealth = Integer.MIN_VALUE;
       int wealth = 0;

       for (int i = 0; i < accounts.length; i++) {
           for (int j = 0; j < accounts[i].length; j++) {
              wealth += accounts[i][j];
           }
           maxWealth = Math.max(maxWealth, wealth);
           wealth = 0;
       }

       return maxWealth;
    }

    public static void main(String[] args) {
       int[][] m = new int[][]{
                               {1,2,3},
                               {3,2,1}
                                      };

        System.out.println(maximumWealth(m));
    }
}
