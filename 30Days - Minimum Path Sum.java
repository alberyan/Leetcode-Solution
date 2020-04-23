class SolutionTLE {
    int res = Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        getPathSum(grid, 0, 0, 0);
        return res;
    }

    private void getPathSum(int[][] grid, int x, int y, int count) {
        int rows = grid.length, cols = grid[0].length;
        if (x >= rows || y >= cols) return;
        if (x == rows - 1 && y == cols - 1) {
            res = Math.min(res, count + grid[x][y]);
            return;
        }
        getPathSum(grid, x + 1, y, count + grid[x][y]);
        getPathSum(grid, x, y + 1, count + grid[x][y]);
    }
}

class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        for (int j = 1; j < cols; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        for (int i = 1; i < rows; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[rows - 1][cols - 1];
    }
}

//ACC
