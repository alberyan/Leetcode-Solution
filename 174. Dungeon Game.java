class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length, cols = dungeon[0].length;
        int[][] dp = new int[rows][cols];
        dp[rows - 1][cols - 1] = Math.max(1 - dungeon[rows - 1][cols - 1], 1);
        for (int j = cols - 2; j >= 0; j--) {
            dp[rows - 1][j] = Math.max(dp[rows - 1][j + 1] - dungeon[rows - 1][j], 1);
        }
        for (int i = rows - 2; i >= 0; i--) {
            dp[i][cols - 1] = Math.max(dp[i + 1][cols - 1] - dungeon[i][cols - 1], 1);
        }
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                int right = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                int down = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                dp[i][j] = Math.min(right, down);
            }
        }
        return dp[0][0];
    }
}

// Runtime: 2 ms, faster than 51.36% of Java online submissions for Dungeon Game.
// Memory Usage: 39.1 MB, less than 60.31% of Java online submissions for Dungeon Game.