class Solution {
    public int maxProfit(int[] prices) {
        int oneBuy = Integer.MIN_VALUE;
        int oneBuyOneSell = 0;
        int twoBuy = Integer.MIN_VALUE;
        int twoBuyTwoSell = 0;
        for (int i = 0; i < prices.length; i++) {
            oneBuy = Math.max(oneBuy, -prices[i]);// we set prices to negative, so the calculation of profit will be
                                                  // convenient
            oneBuyOneSell = Math.max(oneBuyOneSell, prices[i] + oneBuy);
            twoBuy = Math.max(twoBuy, oneBuyOneSell - prices[i]);// we can buy the second only after first is sold
            twoBuyTwoSell = Math.max(twoBuyTwoSell, twoBuy + prices[i]);
        }

        return Math.max(oneBuyOneSell, twoBuyTwoSell);
    }
}

// ACC