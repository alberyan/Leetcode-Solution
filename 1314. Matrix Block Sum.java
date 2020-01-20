class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] ans = new int[rows][cols];
        int[][] dp = new int[rows + 1][cols + 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i + 1][j + 1] = mat[i][j] + dp[i][j + 1] + dp[i + 1][j] - dp[i][j];
            }
        }
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int minR = Math.max(0, r - K);
                int minC = Math.max(0, c - K);
                int maxR = Math.min(rows, r + K + 1);
                int maxC = Math.min(cols, c + K + 1);
                ans[r][c] = dp[maxR][maxC] + dp[minR][minC] - dp[maxR][minC] - dp[minR][maxC];
            }
        }
        return ans;
    }
}

// Runtime: 3 ms, faster than 95.72% of Java online submissions for Matrix Block Sum.
// Memory Usage: 49.7 MB, less than 100.00% of Java online submissions for Matrix Block Sum.