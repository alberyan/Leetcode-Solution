class Solution {
    public int maxDistance(int[][] grid) {
        int rows = grid.length;
        int cols = grid.length;
        int[][][] res = new int[rows][cols][4];
        boolean hasZero = false;
        boolean hasOne = false;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (grid[i][j] == 1) {
                    hasOne = true;
                    continue;
                }
                hasZero = true;
                int left = j - 1 >= 0 ? res[i][j - 1][0] : rows + cols;
                int top = i - 1 >= 0 ? res[i - 1][j][0] : rows + cols;
                res[i][j][0] = Math.min(left, top) + 1;
            }
        }
        if (!hasZero || !hasOne) return -1;
        for (int i = 0; i < rows; i++){
            for (int j = cols - 1; j >= 0; j--){
                if (grid[i][j] == 1) continue;
                int right = j + 1 < cols ? res[i][j + 1][1] : rows + cols;
                int top = i - 1 >= 0 ? res[i - 1][j][1] : rows + cols;
                res[i][j][1] = Math.min(right, top) + 1;
            }
        }
        for (int i = rows - 1; i >= 0; i--){
            for (int j = 0; j < cols; j++){
                if (grid[i][j] == 1) continue;
                int left = j - 1 >= 0 ? res[i][j - 1][2] : rows + cols;
                int bot = i + 1 < rows ? res[i + 1][j][2] : rows + cols;
                res[i][j][2] = Math.min(left, bot) + 1;
            }
        }
        for (int i = rows - 1; i >= 0; i--){
            for (int j = cols - 1; j >= 0; j--){
                if (grid[i][j] == 1) continue;
                int right = j + 1 < cols ? res[i][j + 1][3] : rows + cols;
                int bot = i + 1 < rows ? res[i + 1][j][3] : rows + cols;
                res[i][j][3] = Math.min(right, bot) + 1;
            }
        }
        
        int maxDistance = 0;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                int curMin = rows + cols;
                for (int k = 0; k < 4; k++){
                    curMin = Math.min(curMin, res[i][j][k]);
                }
                maxDistance = Math.max(maxDistance, curMin);
            }
        }
        return maxDistance;
    }
}

// ACC