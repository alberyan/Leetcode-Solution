class Solution {
    public int largestAltitude(int[] gain) {
        int res = 0;
        int max = 0;
        for (int g: gain) {
            res += g;
            max = Math.max(res, max);
        }
        return max;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Find the Highest Altitude.
// Memory Usage: 36.7 MB, less than 81.84% of Java online submissions for Find the Highest Altitude.