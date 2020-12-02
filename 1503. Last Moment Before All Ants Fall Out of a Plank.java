class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int maxLeft = 0, maxRight = 0;
        for (int p: left) {
            maxLeft = Math.max(p, maxLeft);
        }
        for (int p: right) {
            maxRight = Math.max(n - p, maxRight);
        }
        return Math.max(maxRight, maxLeft);
    }
}

// Runtime: 1 ms, faster than 92.89% of Java online submissions for Last Moment Before All Ants Fall Out of a Plank.
// Memory Usage: 40.1 MB, less than 100.00% of Java online submissions for Last Moment Before All Ants Fall Out of a Plank.