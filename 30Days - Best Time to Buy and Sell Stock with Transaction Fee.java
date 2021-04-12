class Solution {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length, buying = 0, selling = -prices[0];
        for (int i = 1; i < len; i++) {
            buying = Math.max(buying, selling + prices[i] - fee);
            selling = Math.max(selling, buying - prices[i]);
        }
        return buying;
    }
}