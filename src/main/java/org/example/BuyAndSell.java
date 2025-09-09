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

    public static void main(String[] args) {
        //Positive  scenarios
        int[] prices = {7,1,5,3,6,4};

        //int[] prices = {7,6,4,3,1};
//        System.out.println(bestBuyAndSellStock(prices));
        System.out.println(bestBuyAndSellStockWay2(prices));
    }
}
