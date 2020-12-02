class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count = numBottles;
        while (numBottles >= numExchange) {
            int cur = numBottles / numExchange;
            numBottles %= numExchange;
            count += cur;
            numBottles += cur;
        }
        return count;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Water Bottles.
// Memory Usage: 38 MB, less than 100.00% of Java online submissions for Water Bottles.