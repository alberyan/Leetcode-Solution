class Solution {
    public int xorOperation(int n, int start) {
        int res = start;
        for (int i = 1; i < n; i++) {
            res ^= start + (2 * i);
        }
        return res;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for XOR Operation in an Array.
// Memory Usage: 38.6 MB, less than 100.00% of Java online submissions for XOR Operation in an Array.