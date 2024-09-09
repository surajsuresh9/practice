package arrays;

public class StockMaxProfit {
    public static void main(String[] args) {
        maxProfit(new int[]{7, 10, 1, 3, 6, 9, 2});
        int[] prices = {7, 10, 1, 3, 6, 9, 2};
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > maxProfit) {
                    maxProfit = prices[j] - prices[i];
                }
            }
        }
        System.out.println("The max profit that can be made is: " + maxProfit);
    }

    static void maxProfit(int[] prices) {
        int minBuyPrice = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minBuyPrice) {
                minBuyPrice = prices[i];
            }
            if (prices[i] - minBuyPrice > maxProfit) {
                maxProfit = prices[i] - minBuyPrice;
            }
        }
        System.out.println("maxProfit: " + maxProfit);
    }
}
