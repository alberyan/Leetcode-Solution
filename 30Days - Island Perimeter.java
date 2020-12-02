class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) continue;
                res += 4;
                if (i - 1 >= 0 && grid[i - 1][j] == 1) res--;
                if (j - 1 >= 0 && grid[i][j - 1] == 1) res--;
                if (i + 1 < rows && grid[i + 1][j] == 1) res--;
                if (j + 1 < cols && grid[i][j + 1] == 1) res--;
            }
        }
        return res;
    }
}

// ACC