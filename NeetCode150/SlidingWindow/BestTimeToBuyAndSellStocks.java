package NeetCode150.SlidingWindow;

public class BestTimeToBuyAndSellStocks {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minimum = 100001;
        for(int price: prices){
            if(minimum > price){
                minimum = price;
            } else if(profit < price - minimum){
                profit = price - minimum;
            }
        }

        return profit;
    }
}
