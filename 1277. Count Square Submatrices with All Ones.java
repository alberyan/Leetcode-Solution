class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0)
            return 0;
        int cols = matrix[0].length;
        if (cols == 0)
            return 0;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            dp[i][0] = matrix[i][0];
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 1)
                    dp[i][j] = dp[i][j - 1] + 1;
            }
        }
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dp[i][j] > 0) {
                    int curMin = dp[i][j];
                    for (int k = 1; k <= curMin && i + k - 1 < rows; k++) {
                        int curRow = i + k - 1;
                        int curVal = dp[curRow][j];
                        curMin = Math.min(curMin, curVal);
                        if (k <= curMin)
                            count++;
                    }
                }
            }
        }
        return count;
    }
}

// Runtime: 8 ms, faster than 54.96% of Java online submissions for Count Square
// Submatrices with All Ones.
// Memory Usage: 62 MB, less than 100.00% of Java online submissions for Count
// Square Submatrices with All Ones.