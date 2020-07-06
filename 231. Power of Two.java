class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Power of Two.
// Memory Usage: 36.4 MB, less than 85.25% of Java online submissions for Power of Two.