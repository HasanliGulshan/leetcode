package arrays;

public class MaxProfit {
    public static int maxProfit(int[] prices) {
       int minPrice = Integer.MAX_VALUE;
       int maxProfit = 0;

       for (int price : prices) {
           maxProfit = Math.max(maxProfit, price - minPrice);
           minPrice = Math.min(minPrice, price);
       }

       return maxProfit;
    }

    public static void main(String[] args) {
        int[] a = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(a));
    }
}
