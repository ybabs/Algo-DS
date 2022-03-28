package com.company;

// Selling price needs to be higher than buying price
class Solution{
    public int maxProfit(int [] prices)
    {
        int max_profit = 0;  // Maximum we can make
        int min_price  = Integer.MAX_VALUE; // Minimum value to buy the at

        for(int i = 0; i < prices.length; i++)
        {
            // If the current price is less than the minimum we have at the moment
            // we buy at that price
            if(prices[i] < min_price)
            {
                min_price = prices[i];
            }

            else
            {
                // Our max profit will be the maximum between our current max profit
                // and the profit from the current price - min_price
                max_profit = Math.max(max_profit, prices[i] -min_price);
            }

        }

        return max_profit;

    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
