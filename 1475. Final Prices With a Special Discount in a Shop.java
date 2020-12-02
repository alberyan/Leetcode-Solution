class Solution {
    public int[] finalPrices(int[] prices) {
        int len = prices.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = prices[i];
            for (int j = i + 1; j < len; j++) {
                if (prices[j] <= prices[i]) {
                    res[i] -= prices[j];
                    break;
                }
            }
        }
        return res;
    }
}

// Runtime: 2 ms, faster than 61.81% of Java online submissions for Final Prices With a Special Discount in a Shop.
// Memory Usage: 41.3 MB, less than 100.00% of Java online submissions for Final Prices With a Special Discount in a Shop.