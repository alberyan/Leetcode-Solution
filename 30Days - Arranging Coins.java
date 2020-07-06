class Solution {
    public int arrangeCoins(int n) {
        double total = 0;
        int cur = 1;
        for (cur = 1; total < (double)(n); cur++) {
            total += cur;
        }
        if (total == (double)(n)) return cur - 1;
        return cur - 2;
    }
}

// ACC