class Solution {
    public int minScoreTriangulation(int[] A) {
        int len = A.length;
        int[][] dp = new int[len][len];
        for (int d = 2; d < len; d++) {
            for (int i = 0; i + d < len; i++) {
                int j = i + d;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < i + d; k++)
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + A[i] * A[j] * A[k]);
            }
        }
        return dp[0][len - 1];
    }
}

// Runtime: 4 ms, faster than 100.00% of Java online submissions for Minimum Score Triangulation of Polygon.
// Memory Usage: 35.9 MB, less than 100.00% of Java online submissions for Minimum Score Triangulation of Polygon.
