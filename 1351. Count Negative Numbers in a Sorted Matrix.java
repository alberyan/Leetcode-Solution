class Solution {
    public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] < 0) {
                    res += cols - j;
                    break;
                }
            }
        }
        return res;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Negative Numbers in a Sorted Matrix.
// Memory Usage: 41.5 MB, less than 100.00% of Java online submissions for Count Negative Numbers in a Sorted Matrix.