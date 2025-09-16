package org.example;

public class BuyAndSell {

    public static int bestBuyAndSellStock(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if(price < minPrice) {
            minPrice = price;
            } else {
                //maxProfit = Math.max(maxProfit, price - minPrice);
                int profit = price - minPrice;
                if (profit > maxProfit){
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
    public static int bestBuyAndSellStockWay2(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if(price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
//                int profit = price - minPrice;
//                if (profit > maxProfit){
//                    maxProfit = profit;
//                }
            }
        }
        return maxProfit;
    }
    // Brute force solution
    public static int bestBuyAndSellStockBruteForce(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > maxProfit) {
                    maxProfit = prices[j] - prices[i];
                }
            }
        }
        return maxProfit;
    }

    // Optimized solution (same as bestBuyAndSellStockWay2)
    public static int bestBuyAndSellStockOptimized(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        //Positive  scenarios
        int[] prices = {7,1,5,3,6,4};

        //int[] prices = {7,6,4,3,1};
//        System.out.println(bestBuyAndSellStock(prices));
        System.out.println(bestBuyAndSellStockWay2(prices));
    }
}
